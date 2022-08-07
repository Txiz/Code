package com.txiz.framework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * The type Resource.
 *
 * @author Txiz
 * @since 2022 08/07
 */
public interface Resource {

    /**
     * Gets input stream.
     *
     * @return the input stream
     * @throws IOException the io exception
     */
    InputStream getInputStream() throws IOException;
}
