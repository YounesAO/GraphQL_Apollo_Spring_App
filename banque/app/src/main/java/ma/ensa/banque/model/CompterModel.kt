package ma.ensa.banque.model

data class Compte(
    val id: String,
    val solde: Double,
    val dateCreation: String,
    val type: TypeCompte
)

enum class TypeCompte {
    COURANT, EPARGNE
}