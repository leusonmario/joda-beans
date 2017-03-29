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

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaBean;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.impl.direct.DirectBean;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;
import org.joda.beans.gen.BeanDefinition;
import org.joda.beans.gen.PropertyDefinition;

/**
 * Mock JavaBean, used for testing.
 * This tests a generic ? property.
 * 
 * @author Stephen Colebourne
 */
@BeanDefinition
public class DocumentationHolder extends DirectBean{
    // NOTE: no space between DirectBean and {

    /** The documentation. */
    @PropertyDefinition
    private Documentation<?> documentation;

    //------------------------- AUTOGENERATED START -------------------------
    /**
     * The meta-bean for {@code DocumentationHolder}.
     * @return the meta-bean, not null
     */
    public static DocumentationHolder.Meta meta() {
        return DocumentationHolder.Meta.INSTANCE;
    }

    static {
        MetaBean.register(DocumentationHolder.Meta.INSTANCE);
    }

    @Override
    public DocumentationHolder.Meta metaBean() {
        return DocumentationHolder.Meta.INSTANCE;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the documentation.
     * @return the value of the property
     */
    public Documentation<?> getDocumentation() {
        return documentation;
    }

    /**
     * Sets the documentation.
     * @param documentation  the new value of the property
     */
    public void setDocumentation(Documentation<?> documentation) {
        this.documentation = documentation;
    }

    /**
     * Gets the the {@code documentation} property.
     * @return the property, not null
     */
    public final Property<Documentation<?>> documentation() {
        return metaBean().documentation().createProperty(this);
    }

    //-----------------------------------------------------------------------
    @Override
    public DocumentationHolder clone() {
        return JodaBeanUtils.cloneAlways(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            DocumentationHolder other = (DocumentationHolder) obj;
            return JodaBeanUtils.equal(getDocumentation(), other.getDocumentation());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(getDocumentation());
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(64);
        buf.append("DocumentationHolder{");
        int len = buf.length();
        toString(buf);
        if (buf.length() > len) {
            buf.setLength(buf.length() - 2);
        }
        buf.append('}');
        return buf.toString();
    }

    protected void toString(StringBuilder buf) {
        buf.append("documentation").append('=').append(JodaBeanUtils.toString(getDocumentation())).append(',').append(' ');
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code DocumentationHolder}.
     */
    public static class Meta extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code documentation} property.
         */
        @SuppressWarnings({"unchecked", "rawtypes" })
        private final MetaProperty<Documentation<?>> documentation = DirectMetaProperty.ofReadWrite(
                this, "documentation", DocumentationHolder.class, (Class) Documentation.class);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "documentation");

        /**
         * Restricted constructor.
         */
        protected Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case 1587405498:  // documentation
                    return documentation;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public BeanBuilder<? extends DocumentationHolder> builder() {
            return new DirectBeanBuilder<>(new DocumentationHolder());
        }

        @Override
        public Class<? extends DocumentationHolder> beanType() {
            return DocumentationHolder.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
        /**
         * The meta-property for the {@code documentation} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<Documentation<?>> documentation() {
            return documentation;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 1587405498:  // documentation
                    return ((DocumentationHolder) bean).getDocumentation();
            }
            return super.propertyGet(bean, propertyName, quiet);
        }

        @Override
        protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 1587405498:  // documentation
                    ((DocumentationHolder) bean).setDocumentation((Documentation<?>) newValue);
                    return;
            }
            super.propertySet(bean, propertyName, newValue, quiet);
        }

    }

    //-------------------------- AUTOGENERATED END --------------------------
}
