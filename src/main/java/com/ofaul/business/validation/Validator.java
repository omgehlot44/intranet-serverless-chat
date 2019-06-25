package com.ofaul.business.validation;

import java.util.Optional;

interface Validator <K> {

    Optional<ValidationError> validate(K k);

}
