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
package org.joda.beans;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.Currency;
import java.util.NoSuchElementException;

import org.joda.beans.gen.ImmPerson;
import org.joda.beans.gen.LightImmutable;
import org.joda.beans.gen.MinimalImmutable;
import org.joda.beans.gen.MinimalMutable;
import org.joda.beans.impl.StandaloneMetaProperty;
import org.joda.beans.ser.JodaBeanSer;
import org.testng.annotations.Test;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

/**
 * Test style=minimal.
 */
@Test
public class TestMinimal {

    public void test_immutable() {
        ImmPerson person = ImmPerson.builder().forename("John").surname("Doggett").build();
        MinimalImmutable bean = (MinimalImmutable) MinimalImmutable.meta().builder()
                .set("number", 12)
                .set("street", "Park Lane")
                .set(StandaloneMetaProperty.of("city", MinimalImmutable.meta(), String.class), "Smallville")
                .set("owner", person)
                .set("list", new ArrayList<String>())
                .set("currency", Currency.getInstance("USD"))
                .build();
        
        assertEquals(bean.getNumber(), 12);
        assertEquals(bean.getTown(), Optional.absent());
        assertEquals(bean.getCity(), "Smallville");
        assertEquals(bean.getStreetName(), "Park Lane");
        assertEquals(bean.getOwner(), person);
        assertEquals(bean.getList(), ImmutableList.of());
        
        assertEquals(bean.metaBean().beanType(), MinimalImmutable.class);
        assertEquals(bean.metaBean().metaPropertyCount(), 9);
        assertEquals(bean.metaBean().metaPropertyExists("number"), true);
        assertEquals(bean.metaBean().metaPropertyExists("town"), true);
        assertEquals(bean.metaBean().metaPropertyExists("address"), true);
        assertEquals(bean.metaBean().metaPropertyExists("foobar"), false);
        
        MetaProperty<Object> mp = bean.metaBean().metaProperty("number");
        assertEquals(mp.propertyType(), int.class);
        assertEquals(mp.declaringType(), MinimalImmutable.class);
        assertEquals(mp.get(bean), 12);
        assertEquals(mp.style(), PropertyStyle.IMMUTABLE);
        
        MetaProperty<Object> mp2 = bean.metaBean().metaProperty("town");
        assertEquals(mp2.propertyType(), String.class);
        assertEquals(mp2.propertyGenericType(), String.class);
        assertEquals(mp2.declaringType(), MinimalImmutable.class);
        assertEquals(mp2.get(bean), null);
        assertEquals(mp2.style(), PropertyStyle.IMMUTABLE);
        
        MetaProperty<Object> mp3 = bean.metaBean().metaProperty("address");
        assertEquals(mp3.propertyType(), String.class);
        assertEquals(mp3.propertyGenericType(), String.class);
        assertEquals(mp3.declaringType(), MinimalImmutable.class);
        assertEquals(mp3.get(bean), "12 Park Lane Smallville");
        assertEquals(mp3.style(), PropertyStyle.DERIVED);
        
        assertTrue(JodaBeanSer.PRETTY.xmlWriter().write(bean).contains("<currency>USD<"));
        assertFalse(JodaBeanSer.PRETTY.xmlWriter().write(bean).contains("<town>"));
        
        try {
            LightImmutable.meta().builder().set(mp3, "Nothing");
            fail();
        } catch (NoSuchElementException ex) {
            // expected
        }
    }

    public void test_mutable() {
        MinimalMutable bean = (MinimalMutable) MinimalMutable.meta().builder()
                .set("number", 12)
                .set("street", "Park Lane")
                .set(StandaloneMetaProperty.of("city", MinimalMutable.meta(), String.class), "Smallville")
                .set("list", new ArrayList<String>())
                .set("currency", Currency.getInstance("USD"))
                .build();
        
        assertEquals(bean.getNumber(), 12);
        assertEquals(bean.getTown(), Optional.absent());
        assertEquals(bean.getCity(), "Smallville");
        assertEquals(bean.getStreetName(), "Park Lane");
        assertEquals(bean.getList(), ImmutableList.of());
        assertEquals(bean.getCurrency(), Optional.of(Currency.getInstance("USD")));
        
        bean.setCity("Nodnol");
        assertEquals(bean.getCity(), "Nodnol");
        
        bean.property("city").set("Paris");
        assertEquals(bean.getCity(), "Paris");
        
        bean.metaBean().metaProperty("city").set(bean, "London");
        assertEquals(bean.getCity(), "London");
        
        assertEquals(bean.metaBean().beanType(), MinimalMutable.class);
        assertEquals(bean.metaBean().metaPropertyCount(), 8);
        assertEquals(bean.metaBean().metaPropertyExists("number"), true);
        assertEquals(bean.metaBean().metaPropertyExists("town"), true);
        assertEquals(bean.metaBean().metaPropertyExists("address"), true);
        assertEquals(bean.metaBean().metaPropertyExists("foobar"), false);
        
        MetaProperty<Object> mp = bean.metaBean().metaProperty("number");
        assertEquals(mp.propertyType(), int.class);
        assertEquals(mp.declaringType(), MinimalMutable.class);
        assertEquals(mp.get(bean), 12);
        assertEquals(mp.style(), PropertyStyle.READ_WRITE);
        
        MetaProperty<Object> mp2 = bean.metaBean().metaProperty("currency");
        assertEquals(mp2.propertyType(), Currency.class);
        assertEquals(mp2.propertyGenericType(), Currency.class);
        assertEquals(mp2.declaringType(), MinimalMutable.class);
        assertEquals(mp2.get(bean), Currency.getInstance("USD"));
        assertEquals(mp2.style(), PropertyStyle.READ_WRITE);
        
        MetaProperty<Object> mp3 = bean.metaBean().metaProperty("address");
        assertEquals(mp3.propertyType(), String.class);
        assertEquals(mp3.propertyGenericType(), String.class);
        assertEquals(mp3.declaringType(), MinimalMutable.class);
        assertEquals(mp3.get(bean), "12 Park Lane London");
        assertEquals(mp3.style(), PropertyStyle.DERIVED);
        
        assertTrue(JodaBeanSer.PRETTY.xmlWriter().write(bean).contains("<currency>USD<"));
        assertFalse(JodaBeanSer.PRETTY.xmlWriter().write(bean).contains("<town>"));
        
        try {
            LightImmutable.meta().builder().set(mp3, "Nothing");
            fail();
        } catch (NoSuchElementException ex) {
            // expected
        }
    }

}
