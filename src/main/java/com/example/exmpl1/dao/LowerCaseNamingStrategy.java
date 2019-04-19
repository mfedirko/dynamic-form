package com.example.exmpl1.dao;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class LowerCaseNamingStrategy extends PhysicalNamingStrategyStandardImpl {
    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        return new Identifier( name.getText().toUpperCase(), name.isQuoted() );
    }

    @Override
    public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment context) {
        return new Identifier( name.getText().toUpperCase(), name.isQuoted() );
    }
    @Override
    public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment context) {
        return new Identifier( name.getText().toUpperCase(), name.isQuoted() );
    }

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return new Identifier( name.getText().toUpperCase(), name.isQuoted() );
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment context) {
        return new Identifier( name.getText().toUpperCase(), name.isQuoted() );
    }
}
