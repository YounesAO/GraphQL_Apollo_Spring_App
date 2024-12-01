package ma.ensa.banque.adapter

import android.app.AlertDialog
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import ma.ensa.banque.R
import ma.ensa.banque.databinding.ItemCompteBinding
import ma.ensa.banque.model.Compte

class CompteAdapter(
    private val onDeleteClick: (String) -> Unit
) : RecyclerView.Adapter<CompteAdapter.CompteViewHolder>() {

    private var comptes: List<Compte> = emptyList()

    fun setData(newComptes: List<Compte>) {
        comptes = newComptes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompteViewHolder {
        val binding = ItemCompteBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CompteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CompteViewHolder, position: Int) {
        holder.bind(comptes[position])
    }

    override fun getItemCount() = comptes.size

    inner class CompteViewHolder(private val binding: ItemCompteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(compte: Compte) {
            binding.apply {
                tvSolde.text = "Solde: ${compte.solde}"
                tvType.text = "Type: ${compte.type}"
                tvDate.text = "Date: ${compte.dateCreation}"
                btnDelete.setOnClickListener { showDeleteConfirmation(compte) }
            }
        }

        private fun showDeleteConfirmation(compte: Compte) {
            AlertDialog.Builder(binding.root.context)
                .setTitle("Confirm Deletion")
                .setMessage("Are you sure you want to delete this account?")
                .setPositiveButton("Delete") { _, _ -> onDeleteClick(compte.id) }
                .setNegativeButton("Cancel", null)
                .show()
        }
        fun getContext(): Context {
            // Get context from the first viewholder, or null if none exists
            return (0 until itemCount)
                .firstNotNullOfOrNull { position ->
                    getViewHolder(position)?.itemView?.context
                } ?: throw IllegalStateException("No ViewHolder found")
        }

        fun getCompteAt(position: Int): Compte {
            return comptes[position]
        }

        private fun getViewHolder(position: Int): CompteViewHolder? {
            return getRecyclerView()?.findViewHolderForAdapterPosition(position) as? CompteViewHolder
        }

        private fun getRecyclerView(): RecyclerView? {
            return if (itemCount > 0) {
                getViewHolder(0)?.itemView?.parent as? RecyclerView
            } else null
        }
    }
    class SwipeToDeleteCallback(
        private val adapter: CompteAdapter,
        private val context: Context
    ) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

        private val deleteIcon by lazy {
            ContextCompat.getDrawable(
                context,
                R.drawable.ic_delete
            )
        }
        private val background = ColorDrawable(Color.RED)

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = false

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.adapterPosition
            val compte = adapter.comptes[position]

            AlertDialog.Builder(viewHolder.itemView.context)
                .setTitle("Confirm Deletion")
                .setMessage("Are you sure you want to delete this account?")
                .setPositiveButton("Delete") { _, _ ->
                    adapter.onDeleteClick(compte.id)
                }
                .setNegativeButton("Cancel") { _, _ ->
                    // Restore the item if user cancels
                    adapter.notifyItemChanged(position)
                }
                .show()
        }

        override fun onChildDraw(
            c: Canvas,
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            dX: Float,
            dY: Float,
            actionState: Int,
            isCurrentlyActive: Boolean
        ) {
            val itemView = viewHolder.itemView
            val iconMargin = (itemView.height - deleteIcon?.intrinsicHeight!!) / 2

            // Draw red background
            if (dX > 0) { // Swiping to the right
                background.setBounds(itemView.left, itemView.top, itemView.left + dX.toInt(), itemView.bottom)
            } else { // Swiping to the left
                background.setBounds(itemView.right + dX.toInt(), itemView.top, itemView.right, itemView.bottom)
            }
            background.draw(c)

            // Draw delete icon
            deleteIcon?.let { icon ->
                if (dX > 0) { // Swiping to the right
                    icon.setBounds(
                        itemView.left + iconMargin,
                        itemView.top + iconMargin,
                        itemView.left + iconMargin + icon.intrinsicWidth,
                        itemView.bottom - iconMargin
                    )
                } else { // Swiping to the left
                    icon.setBounds(
                        itemView.right - iconMargin - icon.intrinsicWidth,
                        itemView.top + iconMargin,
                        itemView.right - iconMargin,
                        itemView.bottom - iconMargin
                    )
                }
                icon.draw(c)
            }

            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
        }
    }


    // Rest of your onChildDraw implementation remains the same
    }