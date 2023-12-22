/**
 * OpenAPI Petstore
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI-Generator 6.6.4-amadeus.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */



#include "Name.h"

#include <string>
#include <vector>
#include <map>
#include <sstream>
#include <stdexcept>
#include <regex>
#include <boost/lexical_cast.hpp>
#include <boost/property_tree/ptree.hpp>
#include <boost/property_tree/json_parser.hpp>
#include "helpers.h"

using boost::property_tree::ptree;
using boost::property_tree::read_json;
using boost::property_tree::write_json;

namespace org {
namespace openapitools {
namespace server {
namespace model {

Name::Name(boost::property_tree::ptree const& pt)
{
        fromPropertyTree(pt);
}


std::string Name::toJsonString(bool prettyJson /* = false */) const
{
	std::stringstream ss;
	write_json(ss, this->toPropertyTree(), prettyJson);
    // workaround inspired by: https://stackoverflow.com/a/56395440
    std::regex reg("\\\"([0-9]+\\.{0,1}[0-9]*)\\\"");
    std::string result = std::regex_replace(ss.str(), reg, "$1");
    return result;
}

void Name::fromJsonString(std::string const& jsonString)
{
	std::stringstream ss(jsonString);
	ptree pt;
	read_json(ss,pt);
	this->fromPropertyTree(pt);
}

ptree Name::toPropertyTree() const
{
	ptree pt;
	ptree tmp_node;
	pt.put("name", m_Name);
	pt.put("snake_case", m_Snake_case);
	pt.put("property", m_Property);
	pt.put("123Number", m_r_123Number);
	return pt;
}

void Name::fromPropertyTree(ptree const &pt)
{
	ptree tmp_node;
	m_Name = pt.get("name", 0);
	m_Snake_case = pt.get("snake_case", 0);
	m_Property = pt.get("property", "");
	m_r_123Number = pt.get("123Number", 0);
}

int32_t Name::getName() const
{
    return m_Name;
}

void Name::setName(int32_t value)
{
    m_Name = value;
}


int32_t Name::getSnakeCase() const
{
    return m_Snake_case;
}

void Name::setSnakeCase(int32_t value)
{
    m_Snake_case = value;
}


std::string Name::getProperty() const
{
    return m_Property;
}

void Name::setProperty(std::string value)
{
    m_Property = value;
}


int32_t Name::getR123Number() const
{
    return m_r_123Number;
}

void Name::setR123Number(int32_t value)
{
    m_r_123Number = value;
}



std::vector<Name> createNameVectorFromJsonString(const std::string& json)
{
    std::stringstream sstream(json);
    boost::property_tree::ptree pt;
    boost::property_tree::json_parser::read_json(sstream,pt);

    auto vec = std::vector<Name>();
    for (const auto& child: pt) {
        vec.emplace_back(Name(child.second));
    }

    return vec;
}

}
}
}
}

