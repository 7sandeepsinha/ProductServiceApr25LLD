package dev.sandeep.ProductServiceApr25.dto;

public interface ProductProjection {
    String getName();
    String getDescription();
}
// projections -> interface mimicking/projecting an object containing subset
// of attributes/columns for a model

// create an interface, and add get methods for the attributes,
// convention -> getAttributeName() -> attribute name should match the get method

// use this projection as output for your repo methods

