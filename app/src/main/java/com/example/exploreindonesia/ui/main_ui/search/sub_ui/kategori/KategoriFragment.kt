package com.example.exploreindonesia.ui.main_ui.search.sub_ui.kategori

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exploreindonesia.R
import com.example.exploreindonesia.data.adapter.KategoriAdapter
import com.example.exploreindonesia.data.model.Kategorimodel

class KategoriFragment : Fragment() {

    companion object {
        fun newInstance() = KategoriFragment()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_kategori, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_kategori)
        val adapter = KategoriAdapter(getList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        val search = view.findViewById<SearchView>(R.id.search_bar_kategori)

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                adapter.filter.filter(p0)
                return true
            }
        })


    }

    private fun getList(): ArrayList<Kategorimodel> {
        val image = resources.obtainTypedArray(R.array.gambar_kategori)
        val name = resources.getStringArray(R.array.nama_kategori)
        val list = ArrayList<Kategorimodel>()
        for (i in name.indices) {
            val kategori = Kategorimodel(image.getResourceId(i, -1), name[i])
            list.add(kategori)
        }
        return list
    }
}