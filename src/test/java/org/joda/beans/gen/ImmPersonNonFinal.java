/*
 *  Copyright 2001-present Stephen Colebourne
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.joda.beans.gen;

import java.util.Map;
import java.util.NoSuchElementException;

import org.joda.beans.Bean;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaBean;
import org.joda.beans.MetaProperty;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;
import org.joda.beans.gen.BeanDefinition;
import org.joda.beans.gen.DerivedProperty;
import org.joda.beans.gen.PropertyDefinition;

/**
 * Mock immutable person JavaBean, used for testing.
 * 
 * @author Stephen Colebourne
 */
@BeanDefinition
public class ImmPersonNonFinal implements ImmutableBean {

    /** The forename. */
    @PropertyDefinition
    private final String forename;
    /** The surname. */
    @PropertyDefinition
    private final String surname;

    @DerivedProperty
    public int getAge() {
        return 12;
    }

    //------------------------- AUTOGENERATED START -------------------------
    /**
     * The meta-bean for {@code ImmPersonNonFinal}.
     * @return the meta-bean, not null
     */
    public static ImmPersonNonFinal.Meta meta() {
        return ImmPersonNonFinal.Meta.INSTANCE;
    }

    static {
        MetaBean.register(ImmPersonNonFinal.Meta.INSTANCE);
    }

    /**
     * Returns a builder used to create an instance of the bean.
     * @return the builder, not null
     */
    public static ImmPersonNonFinal.Builder builder() {
        return new ImmPersonNonFinal.Builder();
    }

    /**
     * Restricted constructor.
     * @param builder  the builder to copy from, not null
     */
    protected ImmPersonNonFinal(ImmPersonNonFinal.Builder builder) {
        this.forename = builder.forename;
        this.surname = builder.surname;
    }

    @Override
    public ImmPersonNonFinal.Meta metaBean() {
        return ImmPersonNonFinal.Meta.INSTANCE;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the forename.
     * @return the value of the property
     */
    public String getForename() {
        return forename;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the surname.
     * @return the value of the property
     */
    public String getSurname() {
        return surname;
    }

    //-----------------------------------------------------------------------
    /**
     * Returns a builder that allows this bean to be mutated.
     * @return the mutable builder, not null
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            ImmPersonNonFinal other = (ImmPersonNonFinal) obj;
            return JodaBeanUtils.equal(forename, other.forename) &&
                    JodaBeanUtils.equal(surname, other.surname);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(forename);
        hash = hash * 31 + JodaBeanUtils.hashCode(surname);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(96);
        buf.append("ImmPersonNonFinal{");
        int len = buf.length();
        toString(buf);
        if (buf.length() > len) {
            buf.setLength(buf.length() - 2);
        }
        buf.append('}');
        return buf.toString();
    }

    protected void toString(StringBuilder buf) {
        buf.append("forename").append('=').append(JodaBeanUtils.toString(forename)).append(',').append(' ');
        buf.append("surname").append('=').append(JodaBeanUtils.toString(surname)).append(',').append(' ');
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code ImmPersonNonFinal}.
     */
    public static class Meta extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code forename} property.
         */
        private final MetaProperty<String> forename = DirectMetaProperty.ofImmutable(
                this, "forename", ImmPersonNonFinal.class, String.class);
        /**
         * The meta-property for the {@code surname} property.
         */
        private final MetaProperty<String> surname = DirectMetaProperty.ofImmutable(
                this, "surname", ImmPersonNonFinal.class, String.class);
        /**
         * The meta-property for the {@code age} property.
         */
        private final MetaProperty<Integer> age = DirectMetaProperty.ofDerived(
                this, "age", ImmPersonNonFinal.class, Integer.TYPE);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "forename",
                "surname",
                "age");

        /**
         * Restricted constructor.
         */
        protected Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case 467061063:  // forename
                    return forename;
                case -1852993317:  // surname
                    return surname;
                case 96511:  // age
                    return age;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public ImmPersonNonFinal.Builder builder() {
            return new ImmPersonNonFinal.Builder();
        }

        @Override
        public Class<? extends ImmPersonNonFinal> beanType() {
            return ImmPersonNonFinal.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
        /**
         * The meta-property for the {@code forename} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<String> forename() {
            return forename;
        }

        /**
         * The meta-property for the {@code surname} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<String> surname() {
            return surname;
        }

        /**
         * The meta-property for the {@code age} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<Integer> age() {
            return age;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 467061063:  // forename
                    return ((ImmPersonNonFinal) bean).getForename();
                case -1852993317:  // surname
                    return ((ImmPersonNonFinal) bean).getSurname();
                case 96511:  // age
                    return ((ImmPersonNonFinal) bean).getAge();
            }
            return super.propertyGet(bean, propertyName, quiet);
        }

        @Override
        protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
            metaProperty(propertyName);
            if (quiet) {
                return;
            }
            throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
        }

    }

    //-----------------------------------------------------------------------
    /**
     * The bean-builder for {@code ImmPersonNonFinal}.
     */
    public static class Builder extends DirectFieldsBeanBuilder<ImmPersonNonFinal> {

        private String forename;
        private String surname;

        /**
         * Restricted constructor.
         */
        protected Builder() {
        }

        /**
         * Restricted copy constructor.
         * @param beanToCopy  the bean to copy from, not null
         */
        protected Builder(ImmPersonNonFinal beanToCopy) {
            this.forename = beanToCopy.getForename();
            this.surname = beanToCopy.getSurname();
        }

        //-----------------------------------------------------------------------
        @Override
        public Object get(String propertyName) {
            switch (propertyName.hashCode()) {
                case 467061063:  // forename
                    return forename;
                case -1852993317:  // surname
                    return surname;
                default:
                    throw new NoSuchElementException("Unknown property: " + propertyName);
            }
        }

        @Override
        public Builder set(String propertyName, Object newValue) {
            switch (propertyName.hashCode()) {
                case 467061063:  // forename
                    this.forename = (String) newValue;
                    break;
                case -1852993317:  // surname
                    this.surname = (String) newValue;
                    break;
                default:
                    throw new NoSuchElementException("Unknown property: " + propertyName);
            }
            return this;
        }

        @Override
        public Builder set(MetaProperty<?> property, Object value) {
            super.set(property, value);
            return this;
        }

        @Override
        public ImmPersonNonFinal build() {
            return new ImmPersonNonFinal(this);
        }

        //-----------------------------------------------------------------------
        /**
         * Sets the forename.
         * @param forename  the new value
         * @return this, for chaining, not null
         */
        public Builder forename(String forename) {
            this.forename = forename;
            return this;
        }

        /**
         * Sets the surname.
         * @param surname  the new value
         * @return this, for chaining, not null
         */
        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        //-----------------------------------------------------------------------
        @Override
        public String toString() {
            StringBuilder buf = new StringBuilder(96);
            buf.append("ImmPersonNonFinal.Builder{");
            int len = buf.length();
            toString(buf);
            if (buf.length() > len) {
                buf.setLength(buf.length() - 2);
            }
            buf.append('}');
            return buf.toString();
        }

        protected void toString(StringBuilder buf) {
            buf.append("forename").append('=').append(JodaBeanUtils.toString(forename)).append(',').append(' ');
            buf.append("surname").append('=').append(JodaBeanUtils.toString(surname)).append(',').append(' ');
        }

    }

    //-------------------------- AUTOGENERATED END --------------------------
}
