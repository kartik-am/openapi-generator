<<<<<<< HEAD
# NOTE: This file is auto generated by OpenAPI Generator 6.6.3-amadeus (https://openapi-generator.tech).
=======
# NOTE: This file is auto generated by OpenAPI Generator 7.0.0-SNAPSHOT (https://openapi-generator.tech).
>>>>>>> 635f7952cec10eecf437886ccd03983b655cd6f2
# Do not edit this file manually.

defmodule OpenapiPetstore.Model.Dog do
  @moduledoc """
  
  """

  @derive [Poison.Encoder]
  defstruct [
    :className,
    :color,
    :breed
  ]

  @type t :: %__MODULE__{
    :className => String.t,
    :color => String.t | nil,
    :breed => String.t | nil
  }
end

defimpl Poison.Decoder, for: OpenapiPetstore.Model.Dog do
  def decode(value, _options) do
    value
  end
end

