package com.example.rp18045_parcial3.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.rp18045_parcial3.APIInterface
import com.example.rp18045_parcial3.RetrofitClient
import com.example.rp18045_parcial3.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val texto : EditText = binding.texto
        val boton : Button = binding.enviar
        val resultado : TextView = binding.resultado

        boton.setOnClickListener{

            if(!texto.text.toString().isEmpty()){
                var retrofit = RetrofitClient.getInstance()
                var apiInterface = retrofit.create(APIInterface::class.java)
                lifecycleScope.launchWhenCreated {
                    try {
                        val response = apiInterface.getCaracteres(texto.text.toString())
                        if (response.isSuccessful()) {
                            resultado.text = "caracteres: "+response.body()?.caracteres+"\n"+
                                    "Total: "+response.body()?.total

                        } else {
                            Toast.makeText(
                                context,
                                response.errorBody().toString(),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }catch (Ex:Exception){
                        Log.e("Error",Ex.localizedMessage)
                    }
                }
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}