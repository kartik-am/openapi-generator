# NOTE: This file is auto generated by OpenAPI Generator 6.6.4-amadeus (https://openapi-generator.tech).
# Do not edit this file manually.

defmodule OpenapiPetstore.Model.AllOfWithSingleRef do
  @moduledoc """
  
  """

  @derive [Poison.Encoder]
  defstruct [
    :username,
    :SingleRefType
  ]

  @type t :: %__MODULE__{
    :username => String.t | nil,
    :SingleRefType => OpenapiPetstore.Model.SingleRefType.t | nil
  }
end

defimpl Poison.Decoder, for: OpenapiPetstore.Model.AllOfWithSingleRef do
  import OpenapiPetstore.Deserializer
  def decode(value, options) do
    value
    |> deserialize(:SingleRefType, :struct, OpenapiPetstore.Model.SingleRefType, options)
  end
end

