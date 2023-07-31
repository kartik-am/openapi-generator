/**
 * OpenAPI Petstore
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI-Generator 6.6.1-amadeus.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

/*
 * Pet.h
 *
 * 
 */

#ifndef Pet_H_
#define Pet_H_



#include "Tag.h"
#include <string>
#include "Category.h"
#include <vector>
#include <set>
#include <memory>
#include <vector>
#include <array>
#include <boost/property_tree/ptree.hpp>
#include "helpers.h"

namespace org {
namespace openapitools {
namespace server {
namespace model {

/// <summary>
/// 
/// </summary>
class  Pet 
{
public:
    Pet() = default;
    explicit Pet(boost::property_tree::ptree const& pt);
    virtual ~Pet() = default;

    Pet(const Pet& other) = default; // copy constructor
    Pet(Pet&& other) noexcept = default; // move constructor

    Pet& operator=(const Pet& other) = default; // copy assignment
    Pet& operator=(Pet&& other) noexcept = default; // move assignment

    std::string toJsonString(bool prettyJson = false) const;
    void fromJsonString(std::string const& jsonString);
    boost::property_tree::ptree toPropertyTree() const;
    void fromPropertyTree(boost::property_tree::ptree const& pt);


    /////////////////////////////////////////////
    /// Pet members

    /// <summary>
    /// 
    /// </summary>
    int64_t getId() const;
    void setId(int64_t value);

    /// <summary>
    /// 
    /// </summary>
    Category getCategory() const;
    void setCategory(Category value);

    /// <summary>
    /// 
    /// </summary>
    std::string getName() const;
    void setName(std::string value);

    /// <summary>
    /// 
    /// </summary>
    std::set<std::string> getPhotoUrls() const;
    void setPhotoUrls(std::set<std::string> value);

    /// <summary>
    /// 
    /// </summary>
    std::vector<Tag> getTags() const;
    void setTags(std::vector<Tag> value);

    /// <summary>
    /// pet status in the store
    /// </summary>
    std::string getStatus() const;
    void setStatus(std::string value);

protected:
    int64_t m_Id = 0L;
    Category m_Category;
    std::string m_Name = "";
    std::set<std::string> m_PhotoUrls;
    std::vector<Tag> m_Tags;
    std::string m_Status = "";
};

std::vector<Pet> createPetVectorFromJsonString(const std::string& json);

template<>
inline boost::property_tree::ptree toPt<Pet>(const Pet& val) {
    return val.toPropertyTree();
}

template<>
inline Pet fromPt<Pet>(const boost::property_tree::ptree& pt) {
    Pet ret;
    ret.fromPropertyTree(pt);
    return ret;
}

}
}
}
}

#endif /* Pet_H_ */
