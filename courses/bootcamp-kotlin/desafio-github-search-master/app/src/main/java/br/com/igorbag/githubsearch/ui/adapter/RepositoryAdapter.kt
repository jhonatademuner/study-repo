package br.com.igorbag.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository

class RepositoryAdapter(private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var repoItemLister: (Repository) -> Unit = {}
    var btnShareLister: (Repository) -> Unit = {}

    // Cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    // Pega o conteudo da view e troca pela informacao de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Exemplo de Bind
        holder.repoName.text = repositories[position].name

        // Exemplo de click no item
        holder.itemView.setOnClickListener {
            repoItemLister(repositories[position])

        }

        // Exemplo de click no btn Share
        holder.shareBtn.setOnClickListener {
            btnShareLister(repositories[position])
        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val shareBtn : ImageView
        val repoName : TextView

        init {
            view.apply {
                shareBtn = findViewById(R.id.iv_share)
                repoName = findViewById(R.id.tv_name)
            }
        }
    }

    // Pega a quantidade de repositorios da lista
    override fun getItemCount(): Int = repositories.size
}


