# NOTE: This file is auto generated by OpenAPI Generator 6.6.4-amadeus (https://openapi-generator.tech).
# Do not edit this file manually.

defmodule OpenapiPetstore.Model.ObjectWithDeprecatedFields do
  @moduledoc """
  
  """

  @derive [Poison.Encoder]
  defstruct [
    :uuid,
    :id,
    :deprecatedRef,
    :bars
  ]

  @type t :: %__MODULE__{
    :uuid => String.t | nil,
    :id => float() | nil,
    :deprecatedRef => OpenapiPetstore.Model.DeprecatedObject.t | nil,
    :bars => [OpenapiPetstore.Model.String.t] | nil
  }
end

defimpl Poison.Decoder, for: OpenapiPetstore.Model.ObjectWithDeprecatedFields do
  import OpenapiPetstore.Deserializer
  def decode(value, options) do
    value
    |> deserialize(:deprecatedRef, :struct, OpenapiPetstore.Model.DeprecatedObject, options)
  end
end

