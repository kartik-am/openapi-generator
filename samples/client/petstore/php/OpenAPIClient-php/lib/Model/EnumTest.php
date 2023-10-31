<?php
/**
 * EnumTest
 *
 * PHP version 7.4
 *
 * @category Class
 * @package  OpenAPI\Client
 * @author   OpenAPI Generator team
 * @link     https://openapi-generator.tech
 */

/**
 * OpenAPI Petstore
 *
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * The version of the OpenAPI document: 1.0.0
 * Generated by: https://openapi-generator.tech
 * OpenAPI Generator version: 6.6.3-amadeus
 */

/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

namespace OpenAPI\Client\Model;

use \ArrayAccess;
use \OpenAPI\Client\ObjectSerializer;

/**
 * EnumTest Class Doc Comment
 *
 * @category Class
 * @package  OpenAPI\Client
 * @author   OpenAPI Generator team
 * @link     https://openapi-generator.tech
 * @implements \ArrayAccess<string, mixed>
 */
class EnumTest implements ModelInterface, ArrayAccess, \JsonSerializable
{
    public const DISCRIMINATOR = null;

    /**
      * The original name of the model.
      *
      * @var string
      */
    protected static $openAPIModelName = 'Enum_Test';

    /**
      * Array of property to type mappings. Used for (de)serialization
      *
      * @var string[]
      */
    protected static $openAPITypes = [
        'enum_string' => 'string',
        'enum_string_required' => 'string',
        'enum_integer' => 'int',
        'enum_number' => 'float',
        'outer_enum' => '\OpenAPI\Client\Model\OuterEnum',
        'outer_enum_integer' => '\OpenAPI\Client\Model\OuterEnumInteger',
        'outer_enum_default_value' => '\OpenAPI\Client\Model\OuterEnumDefaultValue',
        'outer_enum_integer_default_value' => '\OpenAPI\Client\Model\OuterEnumIntegerDefaultValue'
    ];

    /**
      * Array of property to format mappings. Used for (de)serialization
      *
      * @var string[]
      * @phpstan-var array<string, string|null>
      * @psalm-var array<string, string|null>
      */
    protected static $openAPIFormats = [
        'enum_string' => null,
        'enum_string_required' => null,
        'enum_integer' => 'int32',
        'enum_number' => 'double',
        'outer_enum' => null,
        'outer_enum_integer' => null,
        'outer_enum_default_value' => null,
        'outer_enum_integer_default_value' => null
    ];

    /**
      * Array of nullable properties. Used for (de)serialization
      *
      * @var boolean[]
      */
    protected static array $openAPINullables = [
        'enum_string' => false,
		'enum_string_required' => false,
		'enum_integer' => false,
		'enum_number' => false,
		'outer_enum' => true,
		'outer_enum_integer' => false,
		'outer_enum_default_value' => false,
		'outer_enum_integer_default_value' => false
    ];

    /**
      * If a nullable field gets set to null, insert it here
      *
      * @var boolean[]
      */
    protected array $openAPINullablesSetToNull = [];

    /**
     * Array of property to type mappings. Used for (de)serialization
     *
     * @return array
     */
    public static function openAPITypes()
    {
        return self::$openAPITypes;
    }

    /**
     * Array of property to format mappings. Used for (de)serialization
     *
     * @return array
     */
    public static function openAPIFormats()
    {
        return self::$openAPIFormats;
    }

    /**
     * Array of nullable properties
     *
     * @return array
     */
    protected static function openAPINullables(): array
    {
        return self::$openAPINullables;
    }

    /**
     * Array of nullable field names deliberately set to null
     *
     * @return boolean[]
     */
    private function getOpenAPINullablesSetToNull(): array
    {
        return $this->openAPINullablesSetToNull;
    }

    /**
     * Setter - Array of nullable field names deliberately set to null
     *
     * @param boolean[] $openAPINullablesSetToNull
     */
    private function setOpenAPINullablesSetToNull(array $openAPINullablesSetToNull): void
    {
        $this->openAPINullablesSetToNull = $openAPINullablesSetToNull;
    }

    /**
     * Checks if a property is nullable
     *
     * @param string $property
     * @return bool
     */
    public static function isNullable(string $property): bool
    {
        return self::openAPINullables()[$property] ?? false;
    }

    /**
     * Checks if a nullable property is set to null.
     *
     * @param string $property
     * @return bool
     */
    public function isNullableSetToNull(string $property): bool
    {
        return in_array($property, $this->getOpenAPINullablesSetToNull(), true);
    }

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'enum_string' => 'enum_string',
        'enum_string_required' => 'enum_string_required',
        'enum_integer' => 'enum_integer',
        'enum_number' => 'enum_number',
        'outer_enum' => 'outerEnum',
        'outer_enum_integer' => 'outerEnumInteger',
        'outer_enum_default_value' => 'outerEnumDefaultValue',
        'outer_enum_integer_default_value' => 'outerEnumIntegerDefaultValue'
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses)
     *
     * @var string[]
     */
    protected static $setters = [
        'enum_string' => 'setEnumString',
        'enum_string_required' => 'setEnumStringRequired',
        'enum_integer' => 'setEnumInteger',
        'enum_number' => 'setEnumNumber',
        'outer_enum' => 'setOuterEnum',
        'outer_enum_integer' => 'setOuterEnumInteger',
        'outer_enum_default_value' => 'setOuterEnumDefaultValue',
        'outer_enum_integer_default_value' => 'setOuterEnumIntegerDefaultValue'
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests)
     *
     * @var string[]
     */
    protected static $getters = [
        'enum_string' => 'getEnumString',
        'enum_string_required' => 'getEnumStringRequired',
        'enum_integer' => 'getEnumInteger',
        'enum_number' => 'getEnumNumber',
        'outer_enum' => 'getOuterEnum',
        'outer_enum_integer' => 'getOuterEnumInteger',
        'outer_enum_default_value' => 'getOuterEnumDefaultValue',
        'outer_enum_integer_default_value' => 'getOuterEnumIntegerDefaultValue'
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name
     *
     * @return array
     */
    public static function attributeMap()
    {
        return self::$attributeMap;
    }

    /**
     * Array of attributes to setter functions (for deserialization of responses)
     *
     * @return array
     */
    public static function setters()
    {
        return self::$setters;
    }

    /**
     * Array of attributes to getter functions (for serialization of requests)
     *
     * @return array
     */
    public static function getters()
    {
        return self::$getters;
    }

    /**
     * The original name of the model.
     *
     * @return string
     */
    public function getModelName()
    {
        return self::$openAPIModelName;
    }

    public const ENUM_STRING_UPPER = 'UPPER';
    public const ENUM_STRING_LOWER = 'lower';
    public const ENUM_STRING_EMPTY = '';
    public const ENUM_STRING_REQUIRED_UPPER = 'UPPER';
    public const ENUM_STRING_REQUIRED_LOWER = 'lower';
    public const ENUM_STRING_REQUIRED_EMPTY = '';
    public const ENUM_INTEGER_1 = 1;
    public const ENUM_INTEGER_MINUS_1 = -1;
    public const ENUM_NUMBER_1_DOT_1 = 1.1;
    public const ENUM_NUMBER_MINUS_1_DOT_2 = -1.2;

    /**
     * Gets allowable values of the enum
     *
     * @return string[]
     */
    public function getEnumStringAllowableValues()
    {
        return [
            self::ENUM_STRING_UPPER,
            self::ENUM_STRING_LOWER,
            self::ENUM_STRING_EMPTY,
        ];
    }

    /**
     * Gets allowable values of the enum
     *
     * @return string[]
     */
    public function getEnumStringRequiredAllowableValues()
    {
        return [
            self::ENUM_STRING_REQUIRED_UPPER,
            self::ENUM_STRING_REQUIRED_LOWER,
            self::ENUM_STRING_REQUIRED_EMPTY,
        ];
    }

    /**
     * Gets allowable values of the enum
     *
     * @return string[]
     */
    public function getEnumIntegerAllowableValues()
    {
        return [
            self::ENUM_INTEGER_1,
            self::ENUM_INTEGER_MINUS_1,
        ];
    }

    /**
     * Gets allowable values of the enum
     *
     * @return string[]
     */
    public function getEnumNumberAllowableValues()
    {
        return [
            self::ENUM_NUMBER_1_DOT_1,
            self::ENUM_NUMBER_MINUS_1_DOT_2,
        ];
    }

    /**
     * Associative array for storing property values
     *
     * @var mixed[]
     */
    protected $container = [];

    /**
     * Constructor
     *
     * @param mixed[] $data Associated array of property values
     *                      initializing the model
     */
    public function __construct(array $data = null)
    {
        $this->setIfExists('enum_string', $data ?? [], null);
        $this->setIfExists('enum_string_required', $data ?? [], null);
        $this->setIfExists('enum_integer', $data ?? [], null);
        $this->setIfExists('enum_number', $data ?? [], null);
        $this->setIfExists('outer_enum', $data ?? [], null);
        $this->setIfExists('outer_enum_integer', $data ?? [], null);
        $this->setIfExists('outer_enum_default_value', $data ?? [], null);
        $this->setIfExists('outer_enum_integer_default_value', $data ?? [], null);
    }

    /**
    * Sets $this->container[$variableName] to the given data or to the given default Value; if $variableName
    * is nullable and its value is set to null in the $fields array, then mark it as "set to null" in the
    * $this->openAPINullablesSetToNull array
    *
    * @param string $variableName
    * @param array  $fields
    * @param mixed  $defaultValue
    */
    private function setIfExists(string $variableName, array $fields, $defaultValue): void
    {
        if (self::isNullable($variableName) && array_key_exists($variableName, $fields) && is_null($fields[$variableName])) {
            $this->openAPINullablesSetToNull[] = $variableName;
        }

        $this->container[$variableName] = $fields[$variableName] ?? $defaultValue;
    }

    /**
     * Show all the invalid properties with reasons.
     *
     * @return array invalid properties with reasons
     */
    public function listInvalidProperties()
    {
        $invalidProperties = [];

        $allowedValues = $this->getEnumStringAllowableValues();
        if (!is_null($this->container['enum_string']) && !in_array($this->container['enum_string'], $allowedValues, true)) {
            $invalidProperties[] = sprintf(
                "invalid value '%s' for 'enum_string', must be one of '%s'",
                $this->container['enum_string'],
                implode("', '", $allowedValues)
            );
        }

        if ($this->container['enum_string_required'] === null) {
            $invalidProperties[] = "'enum_string_required' can't be null";
        }
        $allowedValues = $this->getEnumStringRequiredAllowableValues();
        if (!is_null($this->container['enum_string_required']) && !in_array($this->container['enum_string_required'], $allowedValues, true)) {
            $invalidProperties[] = sprintf(
                "invalid value '%s' for 'enum_string_required', must be one of '%s'",
                $this->container['enum_string_required'],
                implode("', '", $allowedValues)
            );
        }

        $allowedValues = $this->getEnumIntegerAllowableValues();
        if (!is_null($this->container['enum_integer']) && !in_array($this->container['enum_integer'], $allowedValues, true)) {
            $invalidProperties[] = sprintf(
                "invalid value '%s' for 'enum_integer', must be one of '%s'",
                $this->container['enum_integer'],
                implode("', '", $allowedValues)
            );
        }

        $allowedValues = $this->getEnumNumberAllowableValues();
        if (!is_null($this->container['enum_number']) && !in_array($this->container['enum_number'], $allowedValues, true)) {
            $invalidProperties[] = sprintf(
                "invalid value '%s' for 'enum_number', must be one of '%s'",
                $this->container['enum_number'],
                implode("', '", $allowedValues)
            );
        }

        return $invalidProperties;
    }

    /**
     * Validate all the properties in the model
     * return true if all passed
     *
     * @return bool True if all properties are valid
     */
    public function valid()
    {
        return count($this->listInvalidProperties()) === 0;
    }


    /**
     * Gets enum_string
     *
     * @return string|null
     */
    public function getEnumString()
    {
        return $this->container['enum_string'];
    }

    /**
     * Sets enum_string
     *
     * @param string|null $enum_string enum_string
     *
     * @return self
     */
    public function setEnumString($enum_string)
    {
        if (is_null($enum_string)) {
            throw new \InvalidArgumentException('non-nullable enum_string cannot be null');
        }
        $allowedValues = $this->getEnumStringAllowableValues();
        if (!in_array($enum_string, $allowedValues, true)) {
            throw new \InvalidArgumentException(
                sprintf(
                    "Invalid value '%s' for 'enum_string', must be one of '%s'",
                    $enum_string,
                    implode("', '", $allowedValues)
                )
            );
        }
        $this->container['enum_string'] = $enum_string;

        return $this;
    }

    /**
     * Gets enum_string_required
     *
     * @return string
     */
    public function getEnumStringRequired()
    {
        return $this->container['enum_string_required'];
    }

    /**
     * Sets enum_string_required
     *
     * @param string $enum_string_required enum_string_required
     *
     * @return self
     */
    public function setEnumStringRequired($enum_string_required)
    {
        if (is_null($enum_string_required)) {
            throw new \InvalidArgumentException('non-nullable enum_string_required cannot be null');
        }
        $allowedValues = $this->getEnumStringRequiredAllowableValues();
        if (!in_array($enum_string_required, $allowedValues, true)) {
            throw new \InvalidArgumentException(
                sprintf(
                    "Invalid value '%s' for 'enum_string_required', must be one of '%s'",
                    $enum_string_required,
                    implode("', '", $allowedValues)
                )
            );
        }
        $this->container['enum_string_required'] = $enum_string_required;

        return $this;
    }

    /**
     * Gets enum_integer
     *
     * @return int|null
     */
    public function getEnumInteger()
    {
        return $this->container['enum_integer'];
    }

    /**
     * Sets enum_integer
     *
     * @param int|null $enum_integer enum_integer
     *
     * @return self
     */
    public function setEnumInteger($enum_integer)
    {
        if (is_null($enum_integer)) {
            throw new \InvalidArgumentException('non-nullable enum_integer cannot be null');
        }
        $allowedValues = $this->getEnumIntegerAllowableValues();
        if (!in_array($enum_integer, $allowedValues, true)) {
            throw new \InvalidArgumentException(
                sprintf(
                    "Invalid value '%s' for 'enum_integer', must be one of '%s'",
                    $enum_integer,
                    implode("', '", $allowedValues)
                )
            );
        }
        $this->container['enum_integer'] = $enum_integer;

        return $this;
    }

    /**
     * Gets enum_number
     *
     * @return float|null
     */
    public function getEnumNumber()
    {
        return $this->container['enum_number'];
    }

    /**
     * Sets enum_number
     *
     * @param float|null $enum_number enum_number
     *
     * @return self
     */
    public function setEnumNumber($enum_number)
    {
        if (is_null($enum_number)) {
            throw new \InvalidArgumentException('non-nullable enum_number cannot be null');
        }
        $allowedValues = $this->getEnumNumberAllowableValues();
        if (!in_array($enum_number, $allowedValues, true)) {
            throw new \InvalidArgumentException(
                sprintf(
                    "Invalid value '%s' for 'enum_number', must be one of '%s'",
                    $enum_number,
                    implode("', '", $allowedValues)
                )
            );
        }
        $this->container['enum_number'] = $enum_number;

        return $this;
    }

    /**
     * Gets outer_enum
     *
     * @return \OpenAPI\Client\Model\OuterEnum|null
     */
    public function getOuterEnum()
    {
        return $this->container['outer_enum'];
    }

    /**
     * Sets outer_enum
     *
     * @param \OpenAPI\Client\Model\OuterEnum|null $outer_enum outer_enum
     *
     * @return self
     */
    public function setOuterEnum($outer_enum)
    {
        if (is_null($outer_enum)) {
            array_push($this->openAPINullablesSetToNull, 'outer_enum');
        } else {
            $nullablesSetToNull = $this->getOpenAPINullablesSetToNull();
            $index = array_search('outer_enum', $nullablesSetToNull);
            if ($index !== FALSE) {
                unset($nullablesSetToNull[$index]);
                $this->setOpenAPINullablesSetToNull($nullablesSetToNull);
            }
        }
        $this->container['outer_enum'] = $outer_enum;

        return $this;
    }

    /**
     * Gets outer_enum_integer
     *
     * @return \OpenAPI\Client\Model\OuterEnumInteger|null
     */
    public function getOuterEnumInteger()
    {
        return $this->container['outer_enum_integer'];
    }

    /**
     * Sets outer_enum_integer
     *
     * @param \OpenAPI\Client\Model\OuterEnumInteger|null $outer_enum_integer outer_enum_integer
     *
     * @return self
     */
    public function setOuterEnumInteger($outer_enum_integer)
    {
        if (is_null($outer_enum_integer)) {
            throw new \InvalidArgumentException('non-nullable outer_enum_integer cannot be null');
        }
        $this->container['outer_enum_integer'] = $outer_enum_integer;

        return $this;
    }

    /**
     * Gets outer_enum_default_value
     *
     * @return \OpenAPI\Client\Model\OuterEnumDefaultValue|null
     */
    public function getOuterEnumDefaultValue()
    {
        return $this->container['outer_enum_default_value'];
    }

    /**
     * Sets outer_enum_default_value
     *
     * @param \OpenAPI\Client\Model\OuterEnumDefaultValue|null $outer_enum_default_value outer_enum_default_value
     *
     * @return self
     */
    public function setOuterEnumDefaultValue($outer_enum_default_value)
    {
        if (is_null($outer_enum_default_value)) {
            throw new \InvalidArgumentException('non-nullable outer_enum_default_value cannot be null');
        }
        $this->container['outer_enum_default_value'] = $outer_enum_default_value;

        return $this;
    }

    /**
     * Gets outer_enum_integer_default_value
     *
     * @return \OpenAPI\Client\Model\OuterEnumIntegerDefaultValue|null
     */
    public function getOuterEnumIntegerDefaultValue()
    {
        return $this->container['outer_enum_integer_default_value'];
    }

    /**
     * Sets outer_enum_integer_default_value
     *
     * @param \OpenAPI\Client\Model\OuterEnumIntegerDefaultValue|null $outer_enum_integer_default_value outer_enum_integer_default_value
     *
     * @return self
     */
    public function setOuterEnumIntegerDefaultValue($outer_enum_integer_default_value)
    {
        if (is_null($outer_enum_integer_default_value)) {
            throw new \InvalidArgumentException('non-nullable outer_enum_integer_default_value cannot be null');
        }
        $this->container['outer_enum_integer_default_value'] = $outer_enum_integer_default_value;

        return $this;
    }
    /**
     * Returns true if offset exists. False otherwise.
     *
     * @param integer $offset Offset
     *
     * @return boolean
     */
    public function offsetExists($offset): bool
    {
        return isset($this->container[$offset]);
    }

    /**
     * Gets offset.
     *
     * @param integer $offset Offset
     *
     * @return mixed|null
     */
    #[\ReturnTypeWillChange]
    public function offsetGet($offset)
    {
        return $this->container[$offset] ?? null;
    }

    /**
     * Sets value based on offset.
     *
     * @param int|null $offset Offset
     * @param mixed    $value  Value to be set
     *
     * @return void
     */
    public function offsetSet($offset, $value): void
    {
        if (is_null($offset)) {
            $this->container[] = $value;
        } else {
            $this->container[$offset] = $value;
        }
    }

    /**
     * Unsets offset.
     *
     * @param integer $offset Offset
     *
     * @return void
     */
    public function offsetUnset($offset): void
    {
        unset($this->container[$offset]);
    }

    /**
     * Serializes the object to a value that can be serialized natively by json_encode().
     * @link https://www.php.net/manual/en/jsonserializable.jsonserialize.php
     *
     * @return mixed Returns data which can be serialized by json_encode(), which is a value
     * of any type other than a resource.
     */
    #[\ReturnTypeWillChange]
    public function jsonSerialize()
    {
       return ObjectSerializer::sanitizeForSerialization($this);
    }

    /**
     * Gets the string presentation of the object
     *
     * @return string
     */
    public function __toString()
    {
        return json_encode(
            ObjectSerializer::sanitizeForSerialization($this),
            JSON_PRETTY_PRINT
        );
    }

    /**
     * Gets a header-safe presentation of the object
     *
     * @return string
     */
    public function toHeaderValue()
    {
        return json_encode(ObjectSerializer::sanitizeForSerialization($this));
    }
}


