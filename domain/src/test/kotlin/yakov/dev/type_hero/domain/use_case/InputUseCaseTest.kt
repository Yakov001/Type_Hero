package yakov.dev.type_hero.domain.use_case

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.mock
import yakov.dev.type_hero.domain.entity.TypeState

class InputUseCaseTest {

    private val input = " "
    private val inputUseCaseMock = InputUseCase(
        wordBankRepository = wordBankRepository,
        gameFlowUseCase = mock()
    )

    @Test
    fun `not input space when input empty`() = runBlocking {
        inputUseCaseMock.onInput(input)
        val typeState = inputUseCaseMock.typeState.first()
        Assert.assertEquals(typeState.currentInputWord, TypeState().currentInputWord)
    }

    @Test
    fun `correct input`() = runBlocking {
        inputUseCaseMock.onInput("abcd")
        val typeState = inputUseCaseMock.typeState.first()
        Assert.assertEquals(typeState.currentInputWord, "abcd")
    }
}