package com.example.quickprojectlearning.presentation.list

import androidx.annotation.StringRes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickprojectlearning.domain.model.PictureDomain
import com.example.quickprojectlearning.domain.model.PictureRequest

import com.example.quickprojectlearning.domain.usecases.GetPictures
import com.example.quickprojectlearning.util.ExceptionParser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val getDataUseCase: GetPictures) : ViewModel() {

    val ui_state = MutableStateFlow<PictureUiState>(PictureUiState.Loading)

    val uiState: StateFlow<PictureUiState> = ui_state

    fun getPictures() {
        ui_state.value = PictureUiState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = getDataUseCase.execute(PictureRequest(count = 10))
                ui_state.value = PictureUiState.Loaded(result)
            } catch (ex: Exception) {
                ui_state.value = PictureUiState.Error(ExceptionParser.getMessage(ex))
            }

        }
    }


    sealed class PictureUiState {
        object Loading : PictureUiState()
        class Loaded(val pictureDomain: List<PictureDomain>) : PictureUiState()
        class Error(@StringRes val msg: Int) : PictureUiState()
    }

}