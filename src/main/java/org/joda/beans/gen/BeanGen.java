/*
 *  Copyright 2001-2010 Stephen Colebourne
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

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Code generator for a bean.
 * 
 * @author Stephen Colebourne
 */
class BeanGen {

    /** Start marker. */
    private static final String AUTOGENERATED_START = "\t//------------------------- AUTOGENERATED START -------------------------";
    /** End marker. */
    private static final String AUTOGENERATED_END = "\t//-------------------------- AUTOGENERATED END --------------------------";
    /** Pattern to find bean type. */
    private static final Pattern BEAN_TYPE = Pattern.compile(".*class (([A-Z][A-Za-z0-9_]+)(?:<([A-Z])( extends [A-Za-z0-9_]+)?>)?) .*");
    /** Pattern to find super type. */
    private static final Pattern SUPER_TYPE = Pattern.compile(".* extends (([A-Z][A-Za-z0-9_]+)(?:<([A-Z][A-Za-z0-9_]+)>)?).*");

    /** The content to process. */
    private final List<String> content;
    /** The indent. */
    private final String indent;
    /** The prefix. */
    private final String prefix;
    /** The start position of auto-generation. */
    private final int autoStartIndex;
    /** The end position of auto-generation. */
    private final int autoEndIndex;
    /** The region to insert into. */
    private final List<String> insertRegion;
    /** The list of property generators. */
    private final List<PropertyGen> properties;
    /** The data model of the bean. */
    private final GeneratableBean data;

    /**
     * Constructor.
     * @param content  the content to process, not null
     * @param indent  the indent to use, not null
     * @param prefix  the prefix to use, not null
     */
    BeanGen(List<String> content, String indent, String prefix) {
        this.content = content;
        this.indent = indent;
        this.prefix = prefix;
        int beanDefIndex = parseBeanDefinition();
        if (beanDefIndex >= 0) {
            this.data = new GeneratableBean();
            this.data.setConstructable(parseConstructable(beanDefIndex));
            this.data.setTypeParts(parseBeanType(beanDefIndex));
            this.data.setSuperTypeParts(parseBeanSuperType(beanDefIndex));
            this.properties = parseProperties(data);
            this.autoStartIndex = parseStartAutogen();
            this.autoEndIndex = parseEndAutogen();
            this.insertRegion = content.subList(autoStartIndex + 1, autoEndIndex);
        } else {
            this.autoStartIndex = -1;
            this.autoEndIndex = -1;
            this.insertRegion = null;
            this.data = null;
            this.properties = null;
        }
    }

    //-----------------------------------------------------------------------
    void process() {
        if (insertRegion != null) {
            removeOld();
            insertRegion.add("\t///CLOVER:OFF");
            generateMeta();
            generateMetaBean();
            generatePropertyGet();
            generatePropertySet();
            generateGettersSetters();
            generateMetaClass();
            insertRegion.add("\t///CLOVER:ON");
            resolveIndents();
        }
    }

    private void resolveIndents() {
        for (ListIterator<String> it = content.listIterator(); it.hasNext(); ) {
            it.set(it.next().replace("\t", indent));
        }
    }

    //-----------------------------------------------------------------------
    private int parseBeanDefinition() {
        for (int index = 0; index < content.size(); index++) {
            String line = content.get(index).trim();
            if (line.startsWith("@BeanDefinition")) {
                return index;
            }
        }
        return -1;
    }

    private boolean parseConstructable(int defLine) {
        for (int index = defLine; index < content.size(); index++) {
            if (content.get(index).contains(" abstract class ")) {
                return false;
            }
        }
        return true;
    }

    private String[] parseBeanType(int defLine) {
        Matcher matcher = BEAN_TYPE.matcher("");
        for (int index = defLine; index < content.size(); index++) {
            matcher.reset(content.get(index));
            if (matcher.matches()) {
                return new String[] {matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4)};
            }
        }
        throw new RuntimeException("Unable to locate bean class name");
    }

    private String[] parseBeanSuperType(int defLine) {
        Matcher matcher = SUPER_TYPE.matcher("");
        for (int index = defLine; index < content.size(); index++) {
            matcher.reset(content.get(index));
            if (matcher.matches()) {
                return new String[] {matcher.group(1), matcher.group(2), matcher.group(3)};
            }
        }
        throw new RuntimeException("Unable to locate bean superclass");
    }

    private List<PropertyGen> parseProperties(GeneratableBean data) {
        List<PropertyGen> props = new ArrayList<PropertyGen>();
        for (int index = 0; index < content.size(); index++) {
            String line = content.get(index).trim();
            if (line.startsWith("@PropertyDefinition")) {
                PropertyGen prop = new PropertyGen(this, content, index);
                props.add(prop);
                data.getProperties().add(prop.getData());
            }
        }
        return props;
    }

    private int parseStartAutogen() {
        for (int index = 0; index < content.size(); index++) {
            String line = content.get(index).trim();
            if (line.contains(" AUTOGENERATED START ")) {
                content.set(index, AUTOGENERATED_START);
                return index;
            }
        }
        for (int index = content.size() - 1; index >= 0; index--) {
            String line = content.get(index).trim();
            if (line.equals("}")) {
                content.add(index, AUTOGENERATED_START);
                return index;
            }
            if (line.length() > 0) {
                break;
            }
        }
        throw new RuntimeException("Unable to locate start autogeneration point");
    }

    private int parseEndAutogen() {
        for (int index = autoStartIndex; index < content.size(); index++) {
            String line = content.get(index).trim();
            if (line.contains(" AUTOGENERATED END ")) {
                content.set(index, AUTOGENERATED_END);
                return index;
            }
        }
        content.add(autoStartIndex + 1, AUTOGENERATED_END);
        return autoStartIndex + 1;
    }

    private void removeOld() {
        insertRegion.clear();
    }

    //-----------------------------------------------------------------------
    private void generateSeparator() {
        insertRegion.add("\t//-----------------------------------------------------------------------");
    }

    private void generateMeta() {
        insertRegion.add("\t/**");
        insertRegion.add("\t * The meta-bean for {@code " + data.getTypeRaw() + "}.");
        if (data.isTypeGeneric()) {
            insertRegion.add("\t * @param <R>  the bean's generic type");
            insertRegion.add("\t * @return the meta-bean, not null");
            insertRegion.add("\t */");
            insertRegion.add("\t@SuppressWarnings(\"unchecked\")");
            insertRegion.add("\tpublic static <R" + data.getTypeGenericExtends() + "> " + data.getTypeRaw() + ".Meta<R> meta() {");
        } else {
            insertRegion.add("\t * @return the meta-bean, not null");
            insertRegion.add("\t */");
            if (data.isSuperTypeGeneric()) {
                insertRegion.add("\t@SuppressWarnings(\"unchecked\")");
            }
            insertRegion.add("\tpublic static " + data.getTypeRaw() + ".Meta meta() {");
        }
        insertRegion.add("\t\treturn " + data.getTypeRaw() + ".Meta.INSTANCE;");
        insertRegion.add("\t}");
        insertRegion.add("");
    }

    private void generateMetaBean() {
        if (data.isTypeGeneric()) {
            insertRegion.add("\t@SuppressWarnings(\"unchecked\")");
        }
        insertRegion.add("\t@Override");
        insertRegion.add("\tpublic " + data.getTypeRaw() + ".Meta" + data.getTypeGenericName(true) + " metaBean() {");
        insertRegion.add("\t\treturn " + data.getTypeRaw() + ".Meta.INSTANCE;");
        insertRegion.add("\t}");
        insertRegion.add("");
    }

    private void generateGettersSetters() {
        for (PropertyGen prop : properties) {
            generateSeparator();
            insertRegion.addAll(prop.generateGetter());
            insertRegion.addAll(prop.generateSetter());
            insertRegion.addAll(prop.generateProperty());
        }
    }

    private void generatePropertyGet() {
        insertRegion.add("\t@Override");
        insertRegion.add("\tprotected Object propertyGet(String propertyName) {");
        insertRegion.add("\t\tswitch (propertyName.hashCode()) {");
        for (PropertyGen prop : properties) {
            insertRegion.addAll(prop.generatePropertyGetCase());
        }
        insertRegion.add("\t\t}");
        insertRegion.add("\t\treturn super.propertyGet(propertyName);");
        insertRegion.add("\t}");
        insertRegion.add("");
    }

    private void generatePropertySet() {
        boolean generics = false;
        for (GeneratableProperty prop : data.getProperties()) {
            generics |= prop.getReadWrite().isWritable() && prop.isGeneric();
        }
        if (generics) {
            insertRegion.add("\t@SuppressWarnings(\"unchecked\")");
        }
        insertRegion.add("\t@Override");
        insertRegion.add("\tprotected void propertySet(String propertyName, Object newValue) {");
        insertRegion.add("\t\tswitch (propertyName.hashCode()) {");
        for (PropertyGen prop : properties) {
            insertRegion.addAll(prop.generatePropertySetCase());
        }
        insertRegion.add("\t\t}");
        insertRegion.add("\t\tsuper.propertySet(propertyName, newValue);");
        insertRegion.add("\t}");
        insertRegion.add("");
    }

    private void generateMetaClass() {
        generateSeparator();
        insertRegion.add("\t/**");
        insertRegion.add("\t * The meta-bean for {@code " + data.getTypeRaw() + "}.");
        insertRegion.add("\t */");
        String superMeta = (data.isSubclass() ? data.getSuperTypeRaw() + ".Meta" + data.getSuperTypeGeneric(true) : "BasicMetaBean");
        if (data.isTypeGeneric()) {
            insertRegion.add("\tpublic static class Meta" + data.getTypeGeneric(true) + " extends " + superMeta + " {");
        } else {
            insertRegion.add("\tpublic static class Meta extends " + superMeta + " {");
        }
        insertRegion.add("\t\t/**");
        insertRegion.add("\t\t * The singleton instance of the meta-bean.");
        insertRegion.add("\t\t */");
        if (data.isTypeGeneric()) {
            insertRegion.add("\t\t@SuppressWarnings(\"rawtypes\")");
        }
        insertRegion.add("\t\tstatic final Meta INSTANCE = new Meta();");
        insertRegion.add("");
        generateMetaPropertyConstants();
        insertRegion.add("\t\t/**");
        insertRegion.add("\t\t * The meta-properties.");
        insertRegion.add("\t\t */");
        insertRegion.add("\t\tprivate final Map<String, MetaProperty<Object>> " + prefix + "map;");
        insertRegion.add("");
        insertRegion.add("\t\t@SuppressWarnings({\"unchecked\", \"rawtypes\" })");
        insertRegion.add("\t\tprotected Meta() {");
        String dataToCopy = (data.isSubclass() ? "super.metaPropertyMap()" : "");
        insertRegion.add("\t\t\tLinkedHashMap temp = new LinkedHashMap(" + dataToCopy + ");");
        generateMetaMapBuild();
        insertRegion.add("\t\t\t" + prefix + "map = Collections.unmodifiableMap(temp);");
        insertRegion.add("\t\t}");
        insertRegion.add("");
        insertRegion.add("\t\t@Override");
        insertRegion.add("\t\tpublic " + data.getTypeNoExtends() + " createBean() {");
        if (data.isConstructable()) {
            insertRegion.add("\t\t\treturn new " + data.getTypeNoExtends() + "();");
        } else {
            insertRegion.add("\t\t\tthrow new UnsupportedOperationException(\"" + data.getTypeRaw() + " is an abstract class\");");
        }
        insertRegion.add("\t\t}");
        insertRegion.add("");
        if (data.isTypeGeneric()) {
            insertRegion.add("\t\t@SuppressWarnings({\"unchecked\", \"rawtypes\" })");
        }
        insertRegion.add("\t\t@Override");
        insertRegion.add("\t\tpublic Class<? extends " + data.getTypeNoExtends() + "> beanType() {");
        if (data.isTypeGeneric()) {
            insertRegion.add("\t\t\treturn (Class) " + data.getTypeRaw() + ".class;");
        } else {
            insertRegion.add("\t\t\treturn " + data.getTypeNoExtends() + ".class;");
        }
        insertRegion.add("\t\t}");
        insertRegion.add("");
        insertRegion.add("\t\t@Override");
        insertRegion.add("\t\tpublic Map<String, MetaProperty<Object>> metaPropertyMap() {");
        insertRegion.add("\t\t\treturn " + prefix + "map;");
        insertRegion.add("\t\t}");
        insertRegion.add("");
        insertRegion.add("\t\t//-----------------------------------------------------------------------");
        generateMetaProperties();
        insertRegion.add("\t}");
        insertRegion.add("");
    }

    private void generateMetaPropertyConstants() {
        for (PropertyGen prop : properties) {
            insertRegion.addAll(prop.generateMetaPropertyConstant());
        }
    }

    private void generateMetaMapBuild() {
        for (PropertyGen prop : properties) {
            insertRegion.addAll(prop.generateMetaPropertyMapBuild());
        }
    }

    private void generateMetaProperties() {
        for (PropertyGen prop : properties) {
            insertRegion.addAll(prop.generateMetaProperty());
        }
    }

    //-----------------------------------------------------------------------
    boolean isBean() {
        return data != null;
    }

    GeneratableBean getData() {
        return data;
    }

    String getFieldPrefix() {
        return prefix;
    }

}
