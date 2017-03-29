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

import com.google.common.base.Optional;
import org.joda.beans.gen.BeanDefinition;
import org.joda.beans.gen.ImmutableDefaults;
import org.joda.beans.gen.PropertyDefinition;

/**
 * Mock.
 */
@BeanDefinition(factoryName = "of")
public final class ImmOptional implements ImmutableBean {

    // this works but in serialization they fail for lists/maps
    @PropertyDefinition(validate = "notNull")
    private final Optional<String> optString;
    @PropertyDefinition(validate = "notNull")
    private final Optional<String> optStringEmpty;
    // these are the recommended approach, nullable fields, optional getters
    // remove "Guava" to test Java 8 generation
    @PropertyDefinition(get = "optionalGuava")
    private final String optStringGetter;
    @PropertyDefinition(get = "optionalGuava")
    private final Long optLongGetter;
    @PropertyDefinition(get = "optionalGuava")
    private final Integer optIntGetter;
    @PropertyDefinition(get = "optionalGuava")
    private final Double optDoubleGetter;

    @ImmutableDefaults
    private static void applyDefaults(Builder builder) {
        builder.optString = Optional.absent();
        builder.optStringEmpty = Optional.absent();
    }

    //------------------------- AUTOGENERATED START -------------------------
    /**
     * The meta-bean for {@code ImmOptional}.
     * @return the meta-bean, not null
     */
    public static ImmOptional.Meta meta() {
        return ImmOptional.Meta.INSTANCE;
    }

    static {
        MetaBean.register(ImmOptional.Meta.INSTANCE);
    }

    /**
     * Obtains an instance.
     * @param optString  the value of the property, not null
     * @param optStringEmpty  the value of the property, not null
     * @param optStringGetter  the value of the property
     * @param optLongGetter  the value of the property
     * @param optIntGetter  the value of the property
     * @param optDoubleGetter  the value of the property
     * @return the instance
     */
    public static ImmOptional of(
            Optional<String> optString,
            Optional<String> optStringEmpty,
            String optStringGetter,
            Long optLongGetter,
            Integer optIntGetter,
            Double optDoubleGetter) {
        return new ImmOptional(
            optString,
            optStringEmpty,
            optStringGetter,
            optLongGetter,
            optIntGetter,
            optDoubleGetter);
    }

    /**
     * Returns a builder used to create an instance of the bean.
     * @return the builder, not null
     */
    public static ImmOptional.Builder builder() {
        return new ImmOptional.Builder();
    }

    private ImmOptional(
            Optional<String> optString,
            Optional<String> optStringEmpty,
            String optStringGetter,
            Long optLongGetter,
            Integer optIntGetter,
            Double optDoubleGetter) {
        JodaBeanUtils.notNull(optString, "optString");
        JodaBeanUtils.notNull(optStringEmpty, "optStringEmpty");
        this.optString = optString;
        this.optStringEmpty = optStringEmpty;
        this.optStringGetter = optStringGetter;
        this.optLongGetter = optLongGetter;
        this.optIntGetter = optIntGetter;
        this.optDoubleGetter = optDoubleGetter;
    }

    @Override
    public ImmOptional.Meta metaBean() {
        return ImmOptional.Meta.INSTANCE;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the optString.
     * @return the value of the property, not null
     */
    public Optional<String> getOptString() {
        return optString;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the optStringEmpty.
     * @return the value of the property, not null
     */
    public Optional<String> getOptStringEmpty() {
        return optStringEmpty;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the optStringGetter.
     * @return the optional value of the property, not null
     */
    public Optional<String> getOptStringGetter() {
        return Optional.fromNullable(optStringGetter);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the optLongGetter.
     * @return the optional value of the property, not null
     */
    public Optional<Long> getOptLongGetter() {
        return Optional.fromNullable(optLongGetter);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the optIntGetter.
     * @return the optional value of the property, not null
     */
    public Optional<Integer> getOptIntGetter() {
        return Optional.fromNullable(optIntGetter);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the optDoubleGetter.
     * @return the optional value of the property, not null
     */
    public Optional<Double> getOptDoubleGetter() {
        return Optional.fromNullable(optDoubleGetter);
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
            ImmOptional other = (ImmOptional) obj;
            return JodaBeanUtils.equal(optString, other.optString) &&
                    JodaBeanUtils.equal(optStringEmpty, other.optStringEmpty) &&
                    JodaBeanUtils.equal(optStringGetter, other.optStringGetter) &&
                    JodaBeanUtils.equal(optLongGetter, other.optLongGetter) &&
                    JodaBeanUtils.equal(optIntGetter, other.optIntGetter) &&
                    JodaBeanUtils.equal(optDoubleGetter, other.optDoubleGetter);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(optString);
        hash = hash * 31 + JodaBeanUtils.hashCode(optStringEmpty);
        hash = hash * 31 + JodaBeanUtils.hashCode(optStringGetter);
        hash = hash * 31 + JodaBeanUtils.hashCode(optLongGetter);
        hash = hash * 31 + JodaBeanUtils.hashCode(optIntGetter);
        hash = hash * 31 + JodaBeanUtils.hashCode(optDoubleGetter);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(224);
        buf.append("ImmOptional{");
        buf.append("optString").append('=').append(optString).append(',').append(' ');
        buf.append("optStringEmpty").append('=').append(optStringEmpty).append(',').append(' ');
        buf.append("optStringGetter").append('=').append(optStringGetter).append(',').append(' ');
        buf.append("optLongGetter").append('=').append(optLongGetter).append(',').append(' ');
        buf.append("optIntGetter").append('=').append(optIntGetter).append(',').append(' ');
        buf.append("optDoubleGetter").append('=').append(JodaBeanUtils.toString(optDoubleGetter));
        buf.append('}');
        return buf.toString();
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code ImmOptional}.
     */
    public static final class Meta extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code optString} property.
         */
        @SuppressWarnings({"unchecked", "rawtypes" })
        private final MetaProperty<Optional<String>> optString = DirectMetaProperty.ofImmutable(
                this, "optString", ImmOptional.class, (Class) Optional.class);
        /**
         * The meta-property for the {@code optStringEmpty} property.
         */
        @SuppressWarnings({"unchecked", "rawtypes" })
        private final MetaProperty<Optional<String>> optStringEmpty = DirectMetaProperty.ofImmutable(
                this, "optStringEmpty", ImmOptional.class, (Class) Optional.class);
        /**
         * The meta-property for the {@code optStringGetter} property.
         */
        private final MetaProperty<String> optStringGetter = DirectMetaProperty.ofImmutable(
                this, "optStringGetter", ImmOptional.class, String.class);
        /**
         * The meta-property for the {@code optLongGetter} property.
         */
        private final MetaProperty<Long> optLongGetter = DirectMetaProperty.ofImmutable(
                this, "optLongGetter", ImmOptional.class, Long.class);
        /**
         * The meta-property for the {@code optIntGetter} property.
         */
        private final MetaProperty<Integer> optIntGetter = DirectMetaProperty.ofImmutable(
                this, "optIntGetter", ImmOptional.class, Integer.class);
        /**
         * The meta-property for the {@code optDoubleGetter} property.
         */
        private final MetaProperty<Double> optDoubleGetter = DirectMetaProperty.ofImmutable(
                this, "optDoubleGetter", ImmOptional.class, Double.class);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "optString",
                "optStringEmpty",
                "optStringGetter",
                "optLongGetter",
                "optIntGetter",
                "optDoubleGetter");

        /**
         * Restricted constructor.
         */
        private Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case 1220339876:  // optString
                    return optString;
                case -856788215:  // optStringEmpty
                    return optStringEmpty;
                case -740642097:  // optStringGetter
                    return optStringGetter;
                case 2046023098:  // optLongGetter
                    return optLongGetter;
                case -1931360153:  // optIntGetter
                    return optIntGetter;
                case 224984719:  // optDoubleGetter
                    return optDoubleGetter;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public ImmOptional.Builder builder() {
            return new ImmOptional.Builder();
        }

        @Override
        public Class<? extends ImmOptional> beanType() {
            return ImmOptional.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
        /**
         * The meta-property for the {@code optString} property.
         * @return the meta-property, not null
         */
        public MetaProperty<Optional<String>> optString() {
            return optString;
        }

        /**
         * The meta-property for the {@code optStringEmpty} property.
         * @return the meta-property, not null
         */
        public MetaProperty<Optional<String>> optStringEmpty() {
            return optStringEmpty;
        }

        /**
         * The meta-property for the {@code optStringGetter} property.
         * @return the meta-property, not null
         */
        public MetaProperty<String> optStringGetter() {
            return optStringGetter;
        }

        /**
         * The meta-property for the {@code optLongGetter} property.
         * @return the meta-property, not null
         */
        public MetaProperty<Long> optLongGetter() {
            return optLongGetter;
        }

        /**
         * The meta-property for the {@code optIntGetter} property.
         * @return the meta-property, not null
         */
        public MetaProperty<Integer> optIntGetter() {
            return optIntGetter;
        }

        /**
         * The meta-property for the {@code optDoubleGetter} property.
         * @return the meta-property, not null
         */
        public MetaProperty<Double> optDoubleGetter() {
            return optDoubleGetter;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 1220339876:  // optString
                    return ((ImmOptional) bean).getOptString();
                case -856788215:  // optStringEmpty
                    return ((ImmOptional) bean).getOptStringEmpty();
                case -740642097:  // optStringGetter
                    return ((ImmOptional) bean).optStringGetter;
                case 2046023098:  // optLongGetter
                    return ((ImmOptional) bean).optLongGetter;
                case -1931360153:  // optIntGetter
                    return ((ImmOptional) bean).optIntGetter;
                case 224984719:  // optDoubleGetter
                    return ((ImmOptional) bean).optDoubleGetter;
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
     * The bean-builder for {@code ImmOptional}.
     */
    public static final class Builder extends DirectFieldsBeanBuilder<ImmOptional> {

        private Optional<String> optString;
        private Optional<String> optStringEmpty;
        private String optStringGetter;
        private Long optLongGetter;
        private Integer optIntGetter;
        private Double optDoubleGetter;

        /**
         * Restricted constructor.
         */
        private Builder() {
            applyDefaults(this);
        }

        /**
         * Restricted copy constructor.
         * @param beanToCopy  the bean to copy from, not null
         */
        private Builder(ImmOptional beanToCopy) {
            this.optString = beanToCopy.getOptString();
            this.optStringEmpty = beanToCopy.getOptStringEmpty();
            this.optStringGetter = beanToCopy.optStringGetter;
            this.optLongGetter = beanToCopy.optLongGetter;
            this.optIntGetter = beanToCopy.optIntGetter;
            this.optDoubleGetter = beanToCopy.optDoubleGetter;
        }

        //-----------------------------------------------------------------------
        @Override
        public Object get(String propertyName) {
            switch (propertyName.hashCode()) {
                case 1220339876:  // optString
                    return optString;
                case -856788215:  // optStringEmpty
                    return optStringEmpty;
                case -740642097:  // optStringGetter
                    return optStringGetter;
                case 2046023098:  // optLongGetter
                    return optLongGetter;
                case -1931360153:  // optIntGetter
                    return optIntGetter;
                case 224984719:  // optDoubleGetter
                    return optDoubleGetter;
                default:
                    throw new NoSuchElementException("Unknown property: " + propertyName);
            }
        }

        @SuppressWarnings("unchecked")
        @Override
        public Builder set(String propertyName, Object newValue) {
            switch (propertyName.hashCode()) {
                case 1220339876:  // optString
                    this.optString = (Optional<String>) newValue;
                    break;
                case -856788215:  // optStringEmpty
                    this.optStringEmpty = (Optional<String>) newValue;
                    break;
                case -740642097:  // optStringGetter
                    this.optStringGetter = (String) newValue;
                    break;
                case 2046023098:  // optLongGetter
                    this.optLongGetter = (Long) newValue;
                    break;
                case -1931360153:  // optIntGetter
                    this.optIntGetter = (Integer) newValue;
                    break;
                case 224984719:  // optDoubleGetter
                    this.optDoubleGetter = (Double) newValue;
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
        public ImmOptional build() {
            return new ImmOptional(
                    optString,
                    optStringEmpty,
                    optStringGetter,
                    optLongGetter,
                    optIntGetter,
                    optDoubleGetter);
        }

        //-----------------------------------------------------------------------
        /**
         * Sets the optString.
         * @param optString  the new value, not null
         * @return this, for chaining, not null
         */
        public Builder optString(Optional<String> optString) {
            JodaBeanUtils.notNull(optString, "optString");
            this.optString = optString;
            return this;
        }

        /**
         * Sets the optStringEmpty.
         * @param optStringEmpty  the new value, not null
         * @return this, for chaining, not null
         */
        public Builder optStringEmpty(Optional<String> optStringEmpty) {
            JodaBeanUtils.notNull(optStringEmpty, "optStringEmpty");
            this.optStringEmpty = optStringEmpty;
            return this;
        }

        /**
         * Sets the optStringGetter.
         * @param optStringGetter  the new value
         * @return this, for chaining, not null
         */
        public Builder optStringGetter(String optStringGetter) {
            this.optStringGetter = optStringGetter;
            return this;
        }

        /**
         * Sets the optLongGetter.
         * @param optLongGetter  the new value
         * @return this, for chaining, not null
         */
        public Builder optLongGetter(Long optLongGetter) {
            this.optLongGetter = optLongGetter;
            return this;
        }

        /**
         * Sets the optIntGetter.
         * @param optIntGetter  the new value
         * @return this, for chaining, not null
         */
        public Builder optIntGetter(Integer optIntGetter) {
            this.optIntGetter = optIntGetter;
            return this;
        }

        /**
         * Sets the optDoubleGetter.
         * @param optDoubleGetter  the new value
         * @return this, for chaining, not null
         */
        public Builder optDoubleGetter(Double optDoubleGetter) {
            this.optDoubleGetter = optDoubleGetter;
            return this;
        }

        //-----------------------------------------------------------------------
        @Override
        public String toString() {
            StringBuilder buf = new StringBuilder(224);
            buf.append("ImmOptional.Builder{");
            buf.append("optString").append('=').append(JodaBeanUtils.toString(optString)).append(',').append(' ');
            buf.append("optStringEmpty").append('=').append(JodaBeanUtils.toString(optStringEmpty)).append(',').append(' ');
            buf.append("optStringGetter").append('=').append(JodaBeanUtils.toString(optStringGetter)).append(',').append(' ');
            buf.append("optLongGetter").append('=').append(JodaBeanUtils.toString(optLongGetter)).append(',').append(' ');
            buf.append("optIntGetter").append('=').append(JodaBeanUtils.toString(optIntGetter)).append(',').append(' ');
            buf.append("optDoubleGetter").append('=').append(JodaBeanUtils.toString(optDoubleGetter));
            buf.append('}');
            return buf.toString();
        }

    }

    //-------------------------- AUTOGENERATED END --------------------------
}
