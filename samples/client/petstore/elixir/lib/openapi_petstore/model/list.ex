<<<<<<< HEAD
# NOTE: This file is auto generated by OpenAPI Generator 6.6.3-amadeus (https://openapi-generator.tech).
=======
# NOTE: This file is auto generated by OpenAPI Generator 7.0.0-SNAPSHOT (https://openapi-generator.tech).
>>>>>>> 635f7952cec10eecf437886ccd03983b655cd6f2
# Do not edit this file manually.

defmodule OpenapiPetstore.Model.List do
  @moduledoc """
  
  """

  @derive [Poison.Encoder]
  defstruct [
    :"123-list"
  ]

  @type t :: %__MODULE__{
    :"123-list" => String.t | nil
  }
end

defimpl Poison.Decoder, for: OpenapiPetstore.Model.List do
  def decode(value, _options) do
    value
  end
end

