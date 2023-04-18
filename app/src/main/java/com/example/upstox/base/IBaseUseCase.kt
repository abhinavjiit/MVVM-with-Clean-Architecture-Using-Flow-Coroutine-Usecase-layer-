package com.example.upstox.base

import kotlinx.coroutines.flow.Flow


interface IBaseUseCase<in I, out T : Any> {
    suspend operator fun invoke(input: I): Flow<IResult<T>>
}
