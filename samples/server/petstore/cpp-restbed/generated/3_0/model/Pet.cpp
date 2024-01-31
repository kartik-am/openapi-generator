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



#include "Pet.h"

#include <string>
#include <vector>
#include <map>
#include <sstream>
#include <stdexcept>
#include <regex>
#include <algorithm>
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

Pet::Pet(boost::property_tree::ptree const& pt)
{
        fromPropertyTree(pt);
}


std::string Pet::toJsonString(bool prettyJson /* = false */) const
{
	std::stringstream ss;
	write_json(ss, this->toPropertyTree(), prettyJson);
    // workaround inspired by: https://stackoverflow.com/a/56395440
    std::regex reg("\\\"([0-9]+\\.{0,1}[0-9]*)\\\"");
    std::string result = std::regex_replace(ss.str(), reg, "$1");
    return result;
}

void Pet::fromJsonString(std::string const& jsonString)
{
	std::stringstream ss(jsonString);
	ptree pt;
	read_json(ss,pt);
	this->fromPropertyTree(pt);
}

ptree Pet::toPropertyTree() const
{
	ptree pt;
	ptree tmp_node;
	pt.put("id", m_Id);
	pt.add_child("category", m_Category.toPropertyTree());
	pt.put("name", m_Name);
	// generate tree for PhotoUrls
    tmp_node.clear();
	if (!m_PhotoUrls.empty()) {
        tmp_node = toPt(m_PhotoUrls);
		pt.add_child("photoUrls", tmp_node);
		tmp_node.clear();
	}
	// generate tree for Tags
    tmp_node.clear();
	if (!m_Tags.empty()) {
        tmp_node = toPt(m_Tags);
		pt.add_child("tags", tmp_node);
		tmp_node.clear();
	}
	pt.put("status", m_Status);
	return pt;
}

void Pet::fromPropertyTree(ptree const &pt)
{
	ptree tmp_node;
	m_Id = pt.get("id", 0L);
	if (pt.get_child_optional("category")) {
        m_Category = fromPt<Category>(pt.get_child("category"));
	}
	m_Name = pt.get("name", "");
	// push all items of PhotoUrls into member
	if (pt.get_child_optional("photoUrls")) {
        m_PhotoUrls = fromPt<std::set<std::string>>(pt.get_child("photoUrls"));
	}
	// push all items of Tags into member
	if (pt.get_child_optional("tags")) {
        m_Tags = fromPt<std::vector<Tag>>(pt.get_child("tags"));
	}
	setStatus(pt.get("status", ""));
}

int64_t Pet::getId() const
{
    return m_Id;
}

void Pet::setId(int64_t value)
{
    m_Id = value;
}


Category Pet::getCategory() const
{
    return m_Category;
}

void Pet::setCategory(Category value)
{
    m_Category = value;
}


std::string Pet::getName() const
{
    return m_Name;
}

void Pet::setName(std::string value)
{
    m_Name = value;
}


std::set<std::string> Pet::getPhotoUrls() const
{
    return m_PhotoUrls;
}

void Pet::setPhotoUrls(std::set<std::string> value)
{
    m_PhotoUrls = value;
}


std::vector<Tag> Pet::getTags() const
{
    return m_Tags;
}

void Pet::setTags(std::vector<Tag> value)
{
    m_Tags = value;
}


std::string Pet::getStatus() const
{
    return m_Status;
}

void Pet::setStatus(std::string value)
{
    static const std::array<std::string, 3> allowedValues = {
        "available", "pending", "sold"
    };

    if (std::find(allowedValues.begin(), allowedValues.end(), value) != allowedValues.end()) {
		m_Status = value;
	} else {
		throw std::runtime_error("Value " + boost::lexical_cast<std::string>(value) + " not allowed");
	}
}



std::vector<Pet> createPetVectorFromJsonString(const std::string& json)
{
    std::stringstream sstream(json);
    boost::property_tree::ptree pt;
    boost::property_tree::json_parser::read_json(sstream,pt);

    auto vec = std::vector<Pet>();
    for (const auto& child: pt) {
        vec.emplace_back(Pet(child.second));
    }

    return vec;
}

}
}
}
}

