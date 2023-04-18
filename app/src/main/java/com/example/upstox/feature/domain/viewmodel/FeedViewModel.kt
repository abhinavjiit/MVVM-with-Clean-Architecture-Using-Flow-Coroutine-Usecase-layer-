package com.example.upstox.feature.domain.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.upstox.base.IResult
import com.example.upstox.feature.data.model.FeedModel
import com.example.upstox.feature.data.model.FieldData
import com.example.upstox.feature.domain.repository.FeedDataRepository
import com.example.upstox.feature.domain.usecase.GetFeedDataUseCase
import com.example.upstox.feature.util.roundOffDecimal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(private val feedDataUseCase: GetFeedDataUseCase) :
    ViewModel() {

    private var _feedData = MutableLiveData<IResult<FeedModel>>()
    val feedData: LiveData<IResult<FeedModel>> = _feedData

    private var _feedBottomData = MutableStateFlow(FieldData())
    val feedBottomData: StateFlow<FieldData> = _feedBottomData

    fun fetchFeedList(endPoint: String) {
        viewModelScope.launch {
            feedDataUseCase(endPoint).catch {
                _feedData.postValue(IResult.Error(it))
            }.collect {
                if (it is IResult.Success) {
                    it.data?.let { data ->
                        val fieldDto = _feedBottomData.value.copy()
                        data.data.map { item ->
                            fieldDto.currentValue =
                                fieldDto.currentValue + (item.quantity.times(item.ltp))
                            fieldDto.investedValue =
                                fieldDto.currentValue + (item.quantity.times(item.avgPrice.toDouble()))
                            fieldDto.todayPL = item.quantity.times(item.close.minus(item.ltp))
                            item.pnl = item.quantity.times(item.ltp.minus(item.avgPrice.toDouble()))
                                .roundOffDecimal()
                        }

                        fieldDto.currentValue.roundOffDecimal()
                        fieldDto.investedValue.roundOffDecimal()
                        fieldDto.todayPL = fieldDto.todayPL.roundOffDecimal()
                        fieldDto.finalPL =
                            (fieldDto.currentValue - fieldDto.investedValue).roundOffDecimal()

                        _feedData.postValue(IResult.Success(data))
                        _feedBottomData.value = fieldDto

                    }

                }
            }
        }
    }


}