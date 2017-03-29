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

import java.io.Serializable;
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

import com.google.common.collect.ImmutableMap;
import org.joda.beans.gen.BeanDefinition;
import org.joda.beans.gen.PropertyDefinition;

/**
 * Mock JavaBean, used for testing.
 * 
 * @author Stephen Colebourne
 */
@BeanDefinition(constructorScope = "private")
public final class ImmMappedKey implements ImmutableBean, Serializable {

    /**
     * The map of data, keyed by an arbitrary key interface.
     */
    @PropertyDefinition(validate = "notNull", builderType = "Map<? extends IKey, ?>")
    private final ImmutableMap<IKey, Object> data;

    //------------------------- AUTOGENERATED START -------------------------
    /**
     * The meta-bean for {@code ImmMappedKey}.
     * @return the meta-bean, not null
     */
    public static ImmMappedKey.Meta meta() {
        return ImmMappedKey.Meta.INSTANCE;
    }

    static {
        MetaBean.register(ImmMappedKey.Meta.INSTANCE);
    }

    /**
     * The serialization version id.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Returns a builder used to create an instance of the bean.
     * @return the builder, not null
     */
    public static ImmMappedKey.Builder builder() {
        return new ImmMappedKey.Builder();
    }

    private ImmMappedKey(
            Map<? extends IKey, ?> data) {
        JodaBeanUtils.notNull(data, "data");
        this.data = ImmutableMap.copyOf(data);
    }

    @Override
    public ImmMappedKey.Meta metaBean() {
        return ImmMappedKey.Meta.INSTANCE;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the map of data, keyed by an arbitrary key interface.
     * @return the value of the property, not null
     */
    public ImmutableMap<IKey, Object> getData() {
        return data;
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
            ImmMappedKey other = (ImmMappedKey) obj;
            return JodaBeanUtils.equal(data, other.data);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(data);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(64);
        buf.append("ImmMappedKey{");
        buf.append("data").append('=').append(JodaBeanUtils.toString(data));
        buf.append('}');
        return buf.toString();
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code ImmMappedKey}.
     */
    public static final class Meta extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code data} property.
         */
        @SuppressWarnings({"unchecked", "rawtypes" })
        private final MetaProperty<ImmutableMap<IKey, Object>> data = DirectMetaProperty.ofImmutable(
                this, "data", ImmMappedKey.class, (Class) ImmutableMap.class);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "data");

        /**
         * Restricted constructor.
         */
        private Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case 3076010:  // data
                    return data;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public ImmMappedKey.Builder builder() {
            return new ImmMappedKey.Builder();
        }

        @Override
        public Class<? extends ImmMappedKey> beanType() {
            return ImmMappedKey.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
        /**
         * The meta-property for the {@code data} property.
         * @return the meta-property, not null
         */
        public MetaProperty<ImmutableMap<IKey, Object>> data() {
            return data;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 3076010:  // data
                    return ((ImmMappedKey) bean).getData();
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
     * The bean-builder for {@code ImmMappedKey}.
     */
    public static final class Builder extends DirectFieldsBeanBuilder<ImmMappedKey> {

        private Map<? extends IKey, ?> data = ImmutableMap.of();

        /**
         * Restricted constructor.
         */
        private Builder() {
        }

        /**
         * Restricted copy constructor.
         * @param beanToCopy  the bean to copy from, not null
         */
        private Builder(ImmMappedKey beanToCopy) {
            this.data = beanToCopy.getData();
        }

        //-----------------------------------------------------------------------
        @Override
        public Object get(String propertyName) {
            switch (propertyName.hashCode()) {
                case 3076010:  // data
                    return data;
                default:
                    throw new NoSuchElementException("Unknown property: " + propertyName);
            }
        }

        @SuppressWarnings("unchecked")
        @Override
        public Builder set(String propertyName, Object newValue) {
            switch (propertyName.hashCode()) {
                case 3076010:  // data
                    this.data = (Map<? extends IKey, ?>) newValue;
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
        public ImmMappedKey build() {
            return new ImmMappedKey(
                    data);
        }

        //-----------------------------------------------------------------------
        /**
         * Sets the map of data, keyed by an arbitrary key interface.
         * @param data  the new value, not null
         * @return this, for chaining, not null
         */
        public Builder data(Map<? extends IKey, ?> data) {
            JodaBeanUtils.notNull(data, "data");
            this.data = data;
            return this;
        }

        //-----------------------------------------------------------------------
        @Override
        public String toString() {
            StringBuilder buf = new StringBuilder(64);
            buf.append("ImmMappedKey.Builder{");
            buf.append("data").append('=').append(JodaBeanUtils.toString(data));
            buf.append('}');
            return buf.toString();
        }

    }

    //-------------------------- AUTOGENERATED END --------------------------
}
