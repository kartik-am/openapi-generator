<<<<<<< HEAD
# NOTE: This file is auto generated by OpenAPI Generator 6.6.3-amadeus (https://openapi-generator.tech).
=======
# NOTE: This file is auto generated by OpenAPI Generator 7.0.0-SNAPSHOT (https://openapi-generator.tech).
>>>>>>> 635f7952cec10eecf437886ccd03983b655cd6f2
# Do not edit this file manually.

defmodule OpenapiPetstore.Model.ArrayOfArrayOfNumberOnly do
  @moduledoc """
  
  """

  @derive [Poison.Encoder]
  defstruct [
    :ArrayArrayNumber
  ]

  @type t :: %__MODULE__{
    :ArrayArrayNumber => [[float()]] | nil
  }
end

defimpl Poison.Decoder, for: OpenapiPetstore.Model.ArrayOfArrayOfNumberOnly do
  def decode(value, _options) do
    value
  end
end

