/**
 * OpenAPI Petstore
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
<<<<<<< HEAD
 * NOTE: This class is auto generated by OpenAPI-Generator 6.6.3-amadeus.
=======
 * NOTE: This class is auto generated by OpenAPI-Generator 7.0.0-SNAPSHOT.
>>>>>>> 635f7952cec10eecf437886ccd03983b655cd6f2
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

/*
 * Dog_allOf.h
 *
 * 
 */

#ifndef Dog_allOf_H_
#define Dog_allOf_H_



#include <string>
#include <memory>
#include <vector>
#include <boost/property_tree/ptree.hpp>
#include "helpers.h"

namespace org {
namespace openapitools {
namespace server {
namespace model {

/// <summary>
/// 
/// </summary>
class  Dog_allOf 
{
public:
    Dog_allOf() = default;
    explicit Dog_allOf(boost::property_tree::ptree const& pt);
    virtual ~Dog_allOf() = default;

    Dog_allOf(const Dog_allOf& other) = default; // copy constructor
    Dog_allOf(Dog_allOf&& other) noexcept = default; // move constructor

    Dog_allOf& operator=(const Dog_allOf& other) = default; // copy assignment
    Dog_allOf& operator=(Dog_allOf&& other) noexcept = default; // move assignment

    std::string toJsonString(bool prettyJson = false) const;
    void fromJsonString(std::string const& jsonString);
    boost::property_tree::ptree toPropertyTree() const;
    void fromPropertyTree(boost::property_tree::ptree const& pt);


    /////////////////////////////////////////////
    /// Dog_allOf members

    /// <summary>
    /// 
    /// </summary>
    std::string getBreed() const;
    void setBreed(std::string value);

protected:
    std::string m_Breed = "";
};

std::vector<Dog_allOf> createDog_allOfVectorFromJsonString(const std::string& json);

template<>
inline boost::property_tree::ptree toPt<Dog_allOf>(const Dog_allOf& val) {
    return val.toPropertyTree();
}

template<>
inline Dog_allOf fromPt<Dog_allOf>(const boost::property_tree::ptree& pt) {
    Dog_allOf ret;
    ret.fromPropertyTree(pt);
    return ret;
}

}
}
}
}

#endif /* Dog_allOf_H_ */
