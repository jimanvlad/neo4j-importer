package com.graphaware.importer.data.access;

/**
 * A reader of tabular data. Does not have to be (and usually isn't) thread-safe. Therefore, this class should be accessed
 * in a single thread.
 */
public interface DataReader extends DataAccess {

    /**
     * Initialize the reader.
     */
    void initialize();

    /**
     * Open the reader.
     *
     * @param connectionString identification of the data source (e.g. SQL query, file name, etc.)
     * @param hint             human-readable representation of the connection for naming threads, logging, etc.
     */
    void read(String connectionString, String hint);

    /**
     * Close the reader and release all resources.
     * <p/>
     * {@inheritDoc}
     */
    @Override
    void close();

    /**
     * Read a long number from a column.
     *
     * @param columnName name of the column.
     * @return a long number, <code>null</code> if it is empty or not a long.
     */
    Long readLong(String columnName);

    /**
     * Read an int number from a column.
     *
     * @param columnName name of the column.
     * @return a int number, <code>null</code> if it is empty or not an int.
     */
    Integer readInt(String columnName);

    /**
     * Read a long representation of a date from a column.
     *
     * @param columnName name of the column.
     * @return a date as ms since epoch, <code>null</code> if it is empty or not a date.
     */
    Long readDate(String columnName);

    /**
     * Read a string from a column.
     *
     * @param columnName name of the column.
     * @return a string.
     */
    String readString(String columnName);

    /**
     * Get current row number.
     *
     * @return current row number.
     */
    int getRow();

    /**
     * Read the next record, i.e. advance the cursor by 1.
     *
     * @return true iff there was a next record.
     */
    boolean readRecord();

    /**
     * Get the current record in its raw form.
     *
     * @return raw record.
     */
    String getRawRecord();
}