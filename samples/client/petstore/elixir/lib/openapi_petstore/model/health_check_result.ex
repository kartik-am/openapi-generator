<<<<<<< HEAD
# NOTE: This file is auto generated by OpenAPI Generator 6.6.3-amadeus (https://openapi-generator.tech).
=======
# NOTE: This file is auto generated by OpenAPI Generator 7.0.0-SNAPSHOT (https://openapi-generator.tech).
>>>>>>> 635f7952cec10eecf437886ccd03983b655cd6f2
# Do not edit this file manually.

defmodule OpenapiPetstore.Model.HealthCheckResult do
  @moduledoc """
  Just a string to inform instance is up and running. Make it nullable in hope to get it as pointer in generated model.
  """

  @derive [Poison.Encoder]
  defstruct [
    :NullableMessage
  ]

  @type t :: %__MODULE__{
    :NullableMessage => String.t | nil
  }
end

defimpl Poison.Decoder, for: OpenapiPetstore.Model.HealthCheckResult do
  def decode(value, _options) do
    value
  end
end

