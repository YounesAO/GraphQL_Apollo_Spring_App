package ma.ensa.banque.repository

import com.apollographql.apollo3.ApolloClient
import ma.ensa.banque.model.Compte
import ma.ensa.banque.model.TypeCompte as DomainTypeCompte
import ma.ensa.banque.type.CompteRequest
import ma.ensa.banque.type.TypeCompte as GraphQLTypeCompte
import ma.ensa.banque.utils.Resource
import ma.ensa.banque.SaveCompteMutation
import ma.ensa.banque.DeleteCompteMutation
import ma.ensa.banque.GetAllComptesQuery

class CompteRepository(private val apolloClient: ApolloClient) {
    suspend fun getAllComptes(): Resource<List<Compte>> {
        return try {
            val response = apolloClient.query(GetAllComptesQuery()).execute()
            Resource.Success(response.data?.allComptes?.mapNotNull { it?.toCompte() } ?: emptyList())
        } catch (e: Exception) {
            Resource.Error("Error fetching comptes: ${e.message}")
        }
    }

    suspend fun addCompte(compte: CompteRequest): Resource<Compte> {
        return try {
            val response = apolloClient.mutation(SaveCompteMutation(compte)).execute()
            response.data?.saveCompte?.let {
                Resource.Success(it.toCompte())
            } ?: Resource.Error("Error saving compte")
        } catch (e: Exception) {
            Resource.Error("Error saving compte: ${e.message}")
        }
    }

    suspend fun deleteCompte(id: String): Resource<Boolean> {
        return try {
            apolloClient.mutation(DeleteCompteMutation(id)).execute()
            Resource.Success(true)
        } catch (e: Exception) {
            Resource.Error("Error deleting compte: ${e.message}")
        }
    }
}

// Extension function for query response
private fun GetAllComptesQuery.AllCompte.toCompte(): Compte {
    return Compte(
        id = this.id ?: "",
        solde = this.solde ?: 0.0,
        dateCreation = this.dateCreation ?: "",
        type = this.type?.toDomainTypeCompte() ?: DomainTypeCompte.EPARGNE
    )
}

// Extension function for mutation response
private fun SaveCompteMutation.SaveCompte.toCompte(): Compte {
    return Compte(
        id = this.id ?: "",
        solde = this.solde ?: 0.0,
        dateCreation = this.dateCreation ?: "",
        type = this.type?.toDomainTypeCompte() ?: DomainTypeCompte.EPARGNE
    )
}

// Extension function to convert GraphQL TypeCompte to domain TypeCompte
private fun GraphQLTypeCompte.toDomainTypeCompte(): DomainTypeCompte {
    return when (this) {
        GraphQLTypeCompte.EPARGNE -> DomainTypeCompte.EPARGNE
        GraphQLTypeCompte.COURANT -> DomainTypeCompte.COURANT
        GraphQLTypeCompte.UNKNOWN__ -> DomainTypeCompte.EPARGNE // Default to EPARGNE for unknown types
    }
}