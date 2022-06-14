package com.example.rp18045_parcial3.ui.slideshow

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
import com.example.rp18045_parcial3.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {



        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val numeros : EditText = binding.numeros
        val boton : Button = binding.buscar
        val resultado : TextView = binding.vehiculos

        boton.setOnClickListener{

            if(!numeros.text.toString().isEmpty()){
                var retrofit = RetrofitClient.getInstance()
                var apiInterface = retrofit.create(APIInterface::class.java)
                lifecycleScope.launchWhenCreated {
                    try {
                        val response = apiInterface.getVehiculosPorConductor(numeros.text.toString())
                        if (response.isSuccessful()) {
                            resultado.text = "Nombre: "+response.body()?.nombre+"\n\n"

                            for(v in response.body()?.vehiculos!!){
                                resultado.append("${v.matricula} - ${v.propietario} - ${v.marca} - ${v.color} - ${v.anio} \n")
                            }


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