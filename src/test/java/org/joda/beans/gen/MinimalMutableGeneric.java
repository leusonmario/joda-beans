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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;
import java.util.Set;
import org.joda.beans.Property;

/**
 * Mock minimal bean, used for testing.
 * 
 * @author Stephen Colebourne
 */
@BeanDefinition(style = "minimal")
public final class MinimalMutableGeneric<T extends Number> implements Bean, Serializable {

    /**
     * The number.
     */
    @PropertyDefinition
    private T number;
    /**
     * The number.
     */
    @PropertyDefinition
    private final List<T> list = new ArrayList<T>();
    /**
     * The number.
     */
    @PropertyDefinition
    private final Map<String, T> map = new HashMap<String, T>();

    //------------------------- AUTOGENERATED START -------------------------
    ///CLOVER:OFF
    /**
     * The meta-bean for {@code MinimalMutableGeneric}.
     * @return the meta-bean, not null
     */
    @SuppressWarnings("rawtypes")
    public static MinimalMutableGeneric.Meta meta() {
        return MinimalMutableGeneric.Meta.INSTANCE;
    }

    /**
     * The meta-bean for {@code MinimalMutableGeneric}.
     * @param <R>  the bean's generic type
     * @param cls  the bean's generic type
     * @return the meta-bean, not null
     */
    @SuppressWarnings("unchecked")
    public static <R extends Number> MinimalMutableGeneric.Meta<R> metaMinimalMutableGeneric(Class<R> cls) {
        return MinimalMutableGeneric.Meta.INSTANCE;
    }

    static {
        JodaBeanUtils.registerMetaBean(MinimalMutableGeneric.Meta.INSTANCE);
    }

    /**
     * The serialization version id.
     */
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    @Override
    public MinimalMutableGeneric.Meta<T> metaBean() {
        return MinimalMutableGeneric.Meta.INSTANCE;
    }

    @Override
    public <R> Property<R> property(String propertyName) {
        return metaBean().<R>metaProperty(propertyName).createProperty(this);
    }

    @Override
    public Set<String> propertyNames() {
        return metaBean().metaPropertyMap().keySet();
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the number.
     * @return the value of the property
     */
    public T getNumber() {
        return number;
    }

    /**
     * Sets the number.
     * @param number  the new value of the property
     */
    public void setNumber(T number) {
        this.number = number;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the number.
     * @return the value of the property, not null
     */
    public List<T> getList() {
        return list;
    }

    /**
     * Sets the number.
     * @param list  the new value of the property, not null
     */
    public void setList(List<T> list) {
        JodaBeanUtils.notNull(list, "list");
        this.list.clear();
        this.list.addAll(list);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the number.
     * @return the value of the property, not null
     */
    public Map<String, T> getMap() {
        return map;
    }

    /**
     * Sets the number.
     * @param map  the new value of the property, not null
     */
    public void setMap(Map<String, T> map) {
        JodaBeanUtils.notNull(map, "map");
        this.map.clear();
        this.map.putAll(map);
    }

    //-----------------------------------------------------------------------
    @Override
    public MinimalMutableGeneric<T> clone() {
        return JodaBeanUtils.cloneAlways(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            MinimalMutableGeneric<?> other = (MinimalMutableGeneric<?>) obj;
            return JodaBeanUtils.equal(getNumber(), other.getNumber()) &&
                    JodaBeanUtils.equal(getList(), other.getList()) &&
                    JodaBeanUtils.equal(getMap(), other.getMap());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(getNumber());
        hash = hash * 31 + JodaBeanUtils.hashCode(getList());
        hash = hash * 31 + JodaBeanUtils.hashCode(getMap());
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(128);
        buf.append("MinimalMutableGeneric{");
        buf.append("number").append('=').append(getNumber()).append(',').append(' ');
        buf.append("list").append('=').append(getList()).append(',').append(' ');
        buf.append("map").append('=').append(JodaBeanUtils.toString(getMap()));
        buf.append('}');
        return buf.toString();
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code MinimalMutableGeneric}.
     * @param <T>  the type
     */
    public static final class Meta<T extends Number> extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        @SuppressWarnings("rawtypes")
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code number} property.
         */
        @SuppressWarnings({"unchecked", "rawtypes" })
        private final MetaProperty<T> number = (DirectMetaProperty) DirectMetaProperty.ofReadWrite(
                this, "number", MinimalMutableGeneric.class, Object.class);
        /**
         * The meta-property for the {@code list} property.
         */
        @SuppressWarnings({"unchecked", "rawtypes" })
        private final MetaProperty<List<T>> list = DirectMetaProperty.ofReadWrite(
                this, "list", MinimalMutableGeneric.class, (Class) List.class);
        /**
         * The meta-property for the {@code map} property.
         */
        @SuppressWarnings({"unchecked", "rawtypes" })
        private final MetaProperty<Map<String, T>> map = DirectMetaProperty.ofReadWrite(
                this, "map", MinimalMutableGeneric.class, (Class) Map.class);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "number",
                "list",
                "map");

        /**
         * Restricted constructor.
         */
        private Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case -1034364087:  // number
                    return number;
                case 3322014:  // list
                    return list;
                case 107868:  // map
                    return map;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public BeanBuilder<? extends MinimalMutableGeneric<T>> builder() {
            return new DirectBeanBuilder<MinimalMutableGeneric<T>>(new MinimalMutableGeneric<T>());
        }

        @SuppressWarnings({"unchecked", "rawtypes" })
        @Override
        public Class<? extends MinimalMutableGeneric<T>> beanType() {
            return (Class) MinimalMutableGeneric.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case -1034364087:  // number
                    return ((MinimalMutableGeneric<?>) bean).getNumber();
                case 3322014:  // list
                    return ((MinimalMutableGeneric<?>) bean).getList();
                case 107868:  // map
                    return ((MinimalMutableGeneric<?>) bean).getMap();
            }
            return super.propertyGet(bean, propertyName, quiet);
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
            switch (propertyName.hashCode()) {
                case -1034364087:  // number
                    ((MinimalMutableGeneric<T>) bean).setNumber((T) newValue);
                    return;
                case 3322014:  // list
                    ((MinimalMutableGeneric<T>) bean).setList((List<T>) newValue);
                    return;
                case 107868:  // map
                    ((MinimalMutableGeneric<T>) bean).setMap((Map<String, T>) newValue);
                    return;
            }
            super.propertySet(bean, propertyName, newValue, quiet);
        }

        @Override
        protected void validate(Bean bean) {
            JodaBeanUtils.notNull(((MinimalMutableGeneric<?>) bean).list, "list");
            JodaBeanUtils.notNull(((MinimalMutableGeneric<?>) bean).map, "map");
        }

    }

    ///CLOVER:ON
    //-------------------------- AUTOGENERATED END --------------------------
}
