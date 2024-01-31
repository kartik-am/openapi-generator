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
 * HealthCheckResult.h
 *
 * Just a string to inform instance is up and running. Make it nullable in hope to get it as pointer in generated model.
 */

#ifndef HealthCheckResult_H_
#define HealthCheckResult_H_



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
/// Just a string to inform instance is up and running. Make it nullable in hope to get it as pointer in generated model.
/// </summary>
class  HealthCheckResult 
{
public:
    HealthCheckResult() = default;
    explicit HealthCheckResult(boost::property_tree::ptree const& pt);
    virtual ~HealthCheckResult() = default;

    HealthCheckResult(const HealthCheckResult& other) = default; // copy constructor
    HealthCheckResult(HealthCheckResult&& other) noexcept = default; // move constructor

    HealthCheckResult& operator=(const HealthCheckResult& other) = default; // copy assignment
    HealthCheckResult& operator=(HealthCheckResult&& other) noexcept = default; // move assignment

    std::string toJsonString(bool prettyJson = false) const;
    void fromJsonString(std::string const& jsonString);
    boost::property_tree::ptree toPropertyTree() const;
    void fromPropertyTree(boost::property_tree::ptree const& pt);


    /////////////////////////////////////////////
    /// HealthCheckResult members

    /// <summary>
    /// 
    /// </summary>
    std::string getNullableMessage() const;
    void setNullableMessage(std::string value);

protected:
    std::string m_NullableMessage = "";
};

std::vector<HealthCheckResult> createHealthCheckResultVectorFromJsonString(const std::string& json);

template<>
inline boost::property_tree::ptree toPt<HealthCheckResult>(const HealthCheckResult& val) {
    return val.toPropertyTree();
}

template<>
inline HealthCheckResult fromPt<HealthCheckResult>(const boost::property_tree::ptree& pt) {
    HealthCheckResult ret;
    ret.fromPropertyTree(pt);
    return ret;
}

}
}
}
}

#endif /* HealthCheckResult_H_ */
