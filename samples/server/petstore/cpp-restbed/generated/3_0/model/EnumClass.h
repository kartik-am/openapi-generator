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
 * EnumClass.h
 *
 * 
 */

#ifndef EnumClass_H_
#define EnumClass_H_



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
class  EnumClass 
{
public:
    EnumClass() = default;
    explicit EnumClass(boost::property_tree::ptree const& pt);
    virtual ~EnumClass() = default;

    EnumClass(const EnumClass& other) = default; // copy constructor
    EnumClass(EnumClass&& other) noexcept = default; // move constructor

    EnumClass& operator=(const EnumClass& other) = default; // copy assignment
    EnumClass& operator=(EnumClass&& other) noexcept = default; // move assignment

    std::string toJsonString(bool prettyJson = false) const;
    void fromJsonString(std::string const& jsonString);
    boost::property_tree::ptree toPropertyTree() const;
    void fromPropertyTree(boost::property_tree::ptree const& pt);

    std::string toString() const;
    void fromString(const std::string& str);

    /////////////////////////////////////////////
    /// EnumClass members
    std::string getEnumValue() const;
    void setEnumValue(const std::string& val);

protected:
    std::string m_EnumClassEnumValue;
};

std::vector<EnumClass> createEnumClassVectorFromJsonString(const std::string& json);

template<>
inline boost::property_tree::ptree toPt<EnumClass>(const EnumClass& val) {
    return val.toPropertyTree();
}

template<>
inline EnumClass fromPt<EnumClass>(const boost::property_tree::ptree& pt) {
    EnumClass ret;
    ret.fromPropertyTree(pt);
    return ret;
}

}
}
}
}

#endif /* EnumClass_H_ */
