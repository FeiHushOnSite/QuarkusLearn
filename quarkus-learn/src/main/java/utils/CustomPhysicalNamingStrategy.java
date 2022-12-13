package utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 * @program: quarkus-learn
 * @className: CustomPhysicalNamingStrategy
 * @description:
 * @author:
 * @create: 2022-12-12 15:05
 * @Version 1.0
 **/
public class CustomPhysicalNamingStrategy implements PhysicalNamingStrategy {
    @Override
    public Identifier toPhysicalCatalogName(final Identifier identifier, final JdbcEnvironment jdbcEnvironment) {
        return convertToSnakeCase(identifier);
    }

    @Override
    public Identifier toPhysicalSchemaName(final Identifier identifier, final JdbcEnvironment jdbcEnvironment) {
        return convertToSnakeCase(identifier);
    }

    @Override
    public Identifier toPhysicalTableName(final Identifier identifier, final JdbcEnvironment jdbcEnvironment) {
        return convertToSnakeCase(identifier);
    }

    @Override
    public Identifier toPhysicalSequenceName(final Identifier identifier, final JdbcEnvironment jdbcEnvironment) {
        return convertToSnakeCase(identifier);
    }

    @Override
    public Identifier toPhysicalColumnName(final Identifier identifier, final JdbcEnvironment jdbcEnvironment) {
        return convertToSnakeCase(identifier);
    }

    /**
     * 将驼峰转为下划线分割
     * @param identifier 识别
     * @return 识别
     */
    private Identifier convertToSnakeCase(final Identifier identifier) {
        if(identifier == null) {
            return identifier;
        }
        String name = identifier.getText();
        String snakeName = name.replaceAll("([a-z]+)([A-Z])+", "$1\\_$2").toLowerCase();
        return !snakeName.equals(name) ? new Identifier(snakeName, identifier.isQuoted()) : identifier;
    }
}
