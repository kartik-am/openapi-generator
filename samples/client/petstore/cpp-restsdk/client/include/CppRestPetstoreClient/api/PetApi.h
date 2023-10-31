/**
 * OpenAPI Petstore
 * This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * The version of the OpenAPI document: 1.0.0
 *
 * NOTE: This class is auto generated by OpenAPI-Generator 6.6.3-amadeus.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

/*
 * PetApi.h
 *
 * 
 */

#ifndef ORG_OPENAPITOOLS_CLIENT_API_PetApi_H_
#define ORG_OPENAPITOOLS_CLIENT_API_PetApi_H_



#include "CppRestPetstoreClient/ApiClient.h"

#include "CppRestPetstoreClient/model/ApiResponse.h"
#include "CppRestPetstoreClient/HttpContent.h"
#include "CppRestPetstoreClient/model/Pet.h"
#include <cpprest/details/basic_types.h>
#include <boost/optional.hpp>

namespace org {
namespace openapitools {
namespace client {
namespace api {

using namespace org::openapitools::client::model;



class  PetApi 
{
public:

    explicit PetApi( std::shared_ptr<const ApiClient> apiClient );

    virtual ~PetApi();

    /// <summary>
    /// Add a new pet to the store
    /// </summary>
    /// <remarks>
    /// 
    /// </remarks>
    /// <param name="body">Pet object that needs to be added to the store</param>
    pplx::task<void> addPet(
        std::shared_ptr<Pet> body
    ) const;
    /// <summary>
    /// Deletes a pet
    /// </summary>
    /// <remarks>
    /// 
    /// </remarks>
    /// <param name="petId">Pet id to delete</param>
    /// <param name="apiKey"> (optional, default to utility::conversions::to_string_t(&quot;&quot;))</param>
    pplx::task<void> deletePet(
        int64_t petId,
        boost::optional<utility::string_t> apiKey
    ) const;
    /// <summary>
    /// Finds Pets by status
    /// </summary>
    /// <remarks>
    /// Multiple status values can be provided with comma separated strings
    /// </remarks>
    /// <param name="status">Status values that need to be considered for filter</param>
    pplx::task<std::vector<std::shared_ptr<Pet>>> findPetsByStatus(
        std::vector<utility::string_t> status
    ) const;
    /// <summary>
    /// Finds Pets by tags
    /// </summary>
    /// <remarks>
    /// Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
    /// </remarks>
    /// <param name="tags">Tags to filter by</param>
    pplx::task<std::vector<std::shared_ptr<Pet>>> findPetsByTags(
        std::vector<utility::string_t> tags
    ) const;
    /// <summary>
    /// Find pet by ID
    /// </summary>
    /// <remarks>
    /// Returns a single pet
    /// </remarks>
    /// <param name="petId">ID of pet to return</param>
    pplx::task<std::shared_ptr<Pet>> getPetById(
        int64_t petId
    ) const;
    /// <summary>
    /// Update an existing pet
    /// </summary>
    /// <remarks>
    /// 
    /// </remarks>
    /// <param name="body">Pet object that needs to be added to the store</param>
    pplx::task<void> updatePet(
        std::shared_ptr<Pet> body
    ) const;
    /// <summary>
    /// Updates a pet in the store with form data
    /// </summary>
    /// <remarks>
    /// 
    /// </remarks>
    /// <param name="petId">ID of pet that needs to be updated</param>
    /// <param name="name">Updated name of the pet (optional, default to utility::conversions::to_string_t(&quot;&quot;))</param>
    /// <param name="status">Updated status of the pet (optional, default to utility::conversions::to_string_t(&quot;&quot;))</param>
    pplx::task<void> updatePetWithForm(
        int64_t petId,
        boost::optional<utility::string_t> name,
        boost::optional<utility::string_t> status
    ) const;
    /// <summary>
    /// uploads an image
    /// </summary>
    /// <remarks>
    /// 
    /// </remarks>
    /// <param name="petId">ID of pet to update</param>
    /// <param name="additionalMetadata">Additional data to pass to server (optional, default to utility::conversions::to_string_t(&quot;&quot;))</param>
    /// <param name="file">file to upload (optional, default to utility::conversions::to_string_t(&quot;&quot;))</param>
    pplx::task<std::shared_ptr<ApiResponse>> uploadFile(
        int64_t petId,
        boost::optional<utility::string_t> additionalMetadata,
        boost::optional<std::shared_ptr<HttpContent>> file
    ) const;

protected:
    std::shared_ptr<const ApiClient> m_ApiClient;
};

}
}
}
}

#endif /* ORG_OPENAPITOOLS_CLIENT_API_PetApi_H_ */

