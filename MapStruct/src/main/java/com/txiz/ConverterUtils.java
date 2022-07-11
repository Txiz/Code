package com.txiz;

import org.mapstruct.factory.Mappers;

/**
 * @author Txiz
 * @since 2022-07-11
 */
public interface ConverterUtils {

    /**
     * The constant USER_CONVERTER.
     */
    UserConverter USER_CONVERTER = Mappers.getMapper(UserConverter.class);
}
