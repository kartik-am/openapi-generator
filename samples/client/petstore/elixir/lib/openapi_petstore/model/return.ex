# NOTE: This file is auto generated by OpenAPI Generator 6.6.2-amadeus (https://openapi-generator.tech).
# Do not edit this file manually.

defmodule OpenapiPetstore.Model.Return do
  @moduledoc """
  Model for testing reserved words
  """

  @derive [Poison.Encoder]
  defstruct [
    :return
  ]

  @type t :: %__MODULE__{
    :return => integer() | nil
  }
end

defimpl Poison.Decoder, for: OpenapiPetstore.Model.Return do
  def decode(value, _options) do
    value
  end
end

