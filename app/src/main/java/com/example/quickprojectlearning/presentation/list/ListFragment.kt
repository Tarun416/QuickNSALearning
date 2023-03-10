package com.example.quickprojectlearning.presentation.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quickprojectlearning.R
import com.example.quickprojectlearning.databinding.FragmentListBinding
import com.example.quickprojectlearning.domain.model.PictureDomain
import com.example.quickprojectlearning.presentation.MainActivity
import com.example.quickprojectlearning.util.SpacesItemDecoration
import com.example.quickprojectlearning.util.hide
import com.example.quickprojectlearning.util.show

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListFragment : Fragment(), ListAdapter.OnPicClick {

    private lateinit var binding: FragmentListBinding
    private val viewModel: ListViewModel by viewModels()
    private var pictureslist = ArrayList<PictureDomain>()
    private lateinit var adapter: ListAdapter

    private lateinit var onClickListener: OnClickListener

    companion object {
        fun newInstance() = ListFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onClickListener = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRv()
        initViewModel()
    }

    private fun setRv() {
        adapter = ListAdapter(requireActivity(), this, pictureslist)
        binding.picturerv.layoutManager = GridLayoutManager(requireActivity(), 2)
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.margin_8)
        binding.picturerv.addItemDecoration(SpacesItemDecoration(spacingInPixels))
        binding.picturerv.adapter = adapter
    }


    override fun onPicClick(pos: Int) {
        onClickListener.onPicClick(pictureslist[pos])
    }

    private fun showProgress() {
        binding.progressbar.show()
    }

    private fun hideProgress() {
        binding.progressbar.hide()
    }


    private fun initViewModel() {

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    when (state) {
                        is ListViewModel.PictureUiState.Loaded -> handleData(state.pictureDomain)
                        is ListViewModel.PictureUiState.Error -> handleError(state.msg.toString())
                        is ListViewModel.PictureUiState.Loading -> showProgress()
                    }
                }
            }
        }

        viewModel.getPictures()
    }

    private fun handleError(message: String?) {
        hideProgress()
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }

    private fun handleData(data: List<PictureDomain>?) {
        hideProgress()
        pictureslist.clear()
        pictureslist.addAll(data!!)
        pictureslist.reverse()
        adapter.notifyDataSetChanged()

    }

    interface OnClickListener {
        fun onPicClick(item: PictureDomain)
    }

}