package com.example.segundaprova_jogos

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.segundaprova_jogos.databinding.FragmentHomeBinding
import com.example.segundaprova_jogos.model.Jogo
import com.example.segundaprova_jogos.view_model.HomeFragmentViewModel
import com.example.segundaprova_jogos.views.JogoRecyclerView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {


        private lateinit var _binding:FragmentHomeBinding
        private  lateinit var _view_model: HomeFragmentViewModel


        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

            val jogoRecyclerView = JogoRecyclerView()
            val layout = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            _view_model = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
            _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)

            _binding.viewmodel = _view_model
            _binding.recyclerViewHome.adapter = jogoRecyclerView
            _binding.recyclerViewHome.layoutManager = layout
            _binding.lifecycleOwner = this

             var game1 = Jogo("good of war",2004, mutableListOf<String>("ps1","pc"),5,"primeira franquia de good of war")
            var game2 = Jogo("nfs: underground",2005, mutableListOf<String>("ps2","pc"),5,"corridas de rua noturnas")
            var game3 = Jogo("cs 1.6",2002, mutableListOf<String>("pc"),5,"shooter fps")
            var game4 = Jogo("worms 2",2006, mutableListOf<String>("xbox","pc"),4,"jogo de estratégia")

            jogoRecyclerView.jogos = listOf(game1,game2,game3,game4)
            _view_model.jogos.observe(viewLifecycleOwner) {
                Log.i("obs",it.size.toString())
                if(it.isNotEmpty()) {
                    jogoRecyclerView.jogos = it
                }
            }

            _view_model.on_click.observe(viewLifecycleOwner) {
                if(it) {
                    Navigation.findNavController(_binding.root).navigate(R.id.action_frag1_to_fragCadastrar)
                    _view_model.finish_event()
                }
            }

        return _binding.root
    }

}