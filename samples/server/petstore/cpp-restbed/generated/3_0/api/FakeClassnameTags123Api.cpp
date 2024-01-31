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


#include <corvusoft/restbed/byte.hpp>
#include <corvusoft/restbed/string.hpp>
#include <corvusoft/restbed/settings.hpp>
#include <corvusoft/restbed/request.hpp>
#include <corvusoft/restbed/uri.hpp>
#include <boost/property_tree/ptree.hpp>
#include <boost/property_tree/json_parser.hpp>
#include <boost/lexical_cast.hpp>
#include <boost/algorithm/string.hpp>

#include "FakeClassnameTags123Api.h"

namespace org {
namespace openapitools {
namespace server {
namespace api {

using namespace org::openapitools::server::model;

namespace {
[[maybe_unused]]
std::string selectPreferredContentType(const std::vector<std::string>& contentTypes) {
    if (contentTypes.size() == 0) {
        return "application/json";
    }

    if (contentTypes.size() == 1) {
        return contentTypes.at(0);
    }

    static const std::array<std::string, 2> preferredTypes = {"json", "xml"};
    for (const auto& preferredType: preferredTypes) {
        const auto ret = std::find_if(contentTypes.cbegin(),
        contentTypes.cend(),
        [preferredType](const std::string& str) {
            return str.find(preferredType) != std::string::npos;});
        if (ret != contentTypes.cend()) {
            return *ret;
        }
    }

    return contentTypes.at(0);
}
}

FakeClassnameTags123ApiException::FakeClassnameTags123ApiException(int status_code, std::string what)
  : m_status(status_code),
    m_what(what)
{

}
int FakeClassnameTags123ApiException::getStatus() const
{
    return m_status;
}
const char* FakeClassnameTags123ApiException::what() const noexcept
{
    return m_what.c_str();
}


template<class MODEL_T>
MODEL_T extractJsonModelBodyParam(const std::string& bodyContent)
{
    std::stringstream sstream(bodyContent);
    boost::property_tree::ptree pt;
    boost::property_tree::json_parser::read_json(sstream, pt);

    auto model = MODEL_T(pt);
    return model;
}

template<class MODEL_T>
std::vector<MODEL_T> extractJsonArrayBodyParam(const std::string& bodyContent)
{
    std::stringstream sstream(bodyContent);
    boost::property_tree::ptree pt;
    boost::property_tree::json_parser::read_json(sstream, pt);

    auto arrayRet = std::vector<MODEL_T>();
    for (const auto& child: pt) {
        arrayRet.emplace_back(MODEL_T(child.second));
    }
    return arrayRet;
}

template <class KEY_T, class VAL_T>
std::string convertMapResponse(const std::map<KEY_T, VAL_T>& map)
{
    boost::property_tree::ptree pt;
    for(const auto &kv: map) {
    pt.push_back(boost::property_tree::ptree::value_type(
        boost::lexical_cast<std::string>(kv.first),
        boost::property_tree::ptree(
        boost::lexical_cast<std::string>(kv.second))));
    }
    std::stringstream sstream;
    write_json(sstream, pt);
    std::string result = sstream.str();
    return result;
}

namespace FakeClassnameTags123ApiResources {
Fake_classname_testResource::Fake_classname_testResource(const std::string& context /* = "/v2" */)
{
	this->set_path(context + "/fake_classname_test");
	this->set_method_handler("PATCH",
		std::bind(&Fake_classname_testResource::handler_PATCH_internal, this,
			std::placeholders::_1));
}

std::pair<int, std::string> Fake_classname_testResource::handleFakeClassnameTags123ApiException(const FakeClassnameTags123ApiException& e)
{
    return std::make_pair<int, std::string>(e.getStatus(), e.what());
}

std::pair<int, std::string> Fake_classname_testResource::handleStdException(const std::exception& e)
{
    return std::make_pair<int, std::string>(500, e.what());
}

std::pair<int, std::string> Fake_classname_testResource::handleUnspecifiedException()
{
    return std::make_pair<int, std::string>(500, "Unknown exception occurred");
}

void Fake_classname_testResource::setResponseHeader(const std::shared_ptr<restbed::Session>& session, const std::string& header)
{
    session->set_header(header, "");
}

void Fake_classname_testResource::returnResponse(const std::shared_ptr<restbed::Session>& session, const int status, const std::string& result, std::multimap<std::string, std::string>& responseHeaders)
{
    responseHeaders.insert(std::make_pair("Connection", "close"));
    session->close(status, result, responseHeaders);
}

void Fake_classname_testResource::defaultSessionClose(const std::shared_ptr<restbed::Session>& session, const int status, const std::string& result)
{
    session->close(status, result, { {"Connection", "close"} });
}

void Fake_classname_testResource::handler_PATCH_internal(const std::shared_ptr<restbed::Session> session)
{
    const auto request = session->get_request();
    // body params or form params here from the body content string
    std::string bodyContent = extractBodyContent(session);
    auto client = extractJsonModelBodyParam<Client>(bodyContent);
    
    int status_code = 500;
    Client resultObject = Client{};
    std::string result = "";
    
    try {
        std::tie(status_code, resultObject) =
            handler_PATCH(client);
    }
    catch(const FakeClassnameTags123ApiException& e) {
        std::tie(status_code, result) = handleFakeClassnameTags123ApiException(e);
    }
    catch(const std::exception& e) {
        std::tie(status_code, result) = handleStdException(e);
    }
    catch(...) {
        std::tie(status_code, result) = handleUnspecifiedException();
    }
    
    std::multimap< std::string, std::string > responseHeaders {};
    static const std::vector<std::string> contentTypes{
        "application/json",
    };
    static const std::string acceptTypes{
        "application/json, "
    };
    
    if (status_code == 200) {
        responseHeaders.insert(std::make_pair("Content-Type", selectPreferredContentType(contentTypes)));
        if (!acceptTypes.empty()) {
            responseHeaders.insert(std::make_pair("Accept", acceptTypes));
        }
    
        result = resultObject.toJsonString();
        returnResponse(session, 200, result.empty() ? "{}" : result, responseHeaders);
        return;
    }
    defaultSessionClose(session, status_code, result);
}


std::pair<int, Client> Fake_classname_testResource::handler_PATCH(
        Client & client)
{
    return handler_PATCH_func(client);
}


std::string Fake_classname_testResource::extractBodyContent(const std::shared_ptr<restbed::Session>& session) {
  const auto request = session->get_request();
  int content_length = request->get_header("Content-Length", 0);
  std::string bodyContent;
  session->fetch(content_length,
                 [&bodyContent](const std::shared_ptr<restbed::Session> session,
                                const restbed::Bytes &body) {
                   bodyContent = restbed::String::format(
                       "%.*s\n", (int)body.size(), body.data());
                 });
  return bodyContent;
}

std::string Fake_classname_testResource::extractFormParamsFromBody(const std::string& paramName, const std::string& body) {
    const auto uri = restbed::Uri("urlencoded?" + body, true);
    const auto params = uri.get_query_parameters();
    const auto result = params.find(paramName);
    if (result != params.cend()) {
        return result->second;
    }
    return "";
}

} /* namespace FakeClassnameTags123ApiResources */

FakeClassnameTags123Api::FakeClassnameTags123Api(std::shared_ptr<restbed::Service> const& restbedService)
: m_service(restbedService)
{
}

FakeClassnameTags123Api::~FakeClassnameTags123Api() {}

std::shared_ptr<FakeClassnameTags123ApiResources::Fake_classname_testResource> FakeClassnameTags123Api::getFake_classname_testResource() {
    if (!m_spFake_classname_testResource) {
        setResource(std::make_shared<FakeClassnameTags123ApiResources::Fake_classname_testResource>());
    }
    return m_spFake_classname_testResource;
}
void FakeClassnameTags123Api::setResource(std::shared_ptr<FakeClassnameTags123ApiResources::Fake_classname_testResource> resource) {
    m_spFake_classname_testResource = resource;
    m_service->publish(m_spFake_classname_testResource);
}
void FakeClassnameTags123Api::setFakeClassnameTags123ApiFake_classname_testResource(std::shared_ptr<FakeClassnameTags123ApiResources::Fake_classname_testResource> spFake_classname_testResource) {
    m_spFake_classname_testResource = spFake_classname_testResource;
    m_service->publish(m_spFake_classname_testResource);
}


void FakeClassnameTags123Api::publishDefaultResources() {
    if (!m_spFake_classname_testResource) {
        setResource(std::make_shared<FakeClassnameTags123ApiResources::Fake_classname_testResource>());
    }
}

std::shared_ptr<restbed::Service> FakeClassnameTags123Api::service() {
    return m_service;
}


}
}
}
}

