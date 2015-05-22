package com.google.guava.collect;

import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;
import org.mockito.internal.util.collections.Sets;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.*;

/**
 * @author bjxieb
 * @date 5/9/15
 */
public class MapsTest {
    @Test public void test_ArrayListMultimap() {
        ArrayListMultimap multimap = ArrayListMultimap.create();
        multimap.put("key", Lists.newArrayList("a", "b"));
        System.out.println(multimap);
    }

    @Test public void test_set_to_map() {
        Set<String> stringSet = Sets.newSet("lidong", "yuyanxing");
        Map<String, String> maps = Maps.asMap(stringSet, new Function<String, String>() {
            @Override public String apply(String input) {
                return input + "_v";
            }
        });
        Assert.assertEquals("lidong_v", maps.get("lidong"));
        Assert.assertEquals("yuyanxing_v", maps.get("yuyanxing"));
        Assert.assertEquals(2, maps.size());
    }

    @Test public void test_difference() {
        Map<String, String> left = ImmutableMap.of("xiaog", "1", "lidong", "2", "xiaow", "3");
        Map<String, String> right = ImmutableMap.of("yunyanxing", "1", "lidong", "2");
        MapDifference<String, String> difference = Maps.difference(left, right);
        Assert.assertEquals(false, difference.areEqual());
        Assert.assertEquals(2, difference.entriesOnlyOnLeft().size());
    }

    @Test public void test_filterEntries() {
        Map<String, String> maps = ImmutableMap.of("xiaog", "1", "lidong", "2", "xiaow", "3");
        Map<String, String> filteredMap =
            Maps.filterEntries(maps, new Predicate<Map.Entry<String, String>>() {
                @Override public boolean apply(Map.Entry<String, String> input) {
                    if (input.getKey().equals("xiaog")) {
                        return false;
                    }
                    return true;
                }
            });
        Assert.assertEquals(null, filteredMap.get("xiaog"));

    }

    @Test public void test_filterKeys() {
        Map<String, String> maps = ImmutableMap.of("xiaog", "1", "lidong", "2", "xiaow", "3");
        Map<String, String> filterKeysMap = Maps.filterKeys(maps, new Predicate<String>() {
            @Override public boolean apply(String input) {
                if (input.equals("xiaog")) {
                    return false;
                }
                return true;
            }
        });
        Assert.assertEquals(null, filterKeysMap.get("xiaog"));
    }

    @Test public void test_filterValues() {
        Map<String, String> maps = ImmutableMap.of("xiaog", "1", "lidong", "2", "xiaow", "3");
        Map<String, String> filterValuesMap = Maps.filterValues(maps, new Predicate<String>() {
            @Override public boolean apply(String input) {
                if (input.equals("1")) {
                    return false;
                }
                return true;
            }
        });
        Assert.assertEquals(null, filterValuesMap.get("xiaog"));
    }

    @Test public void test_toMap() {
        List<String> keys = Lists.newArrayList("xiaog", "lidong");
        Map<String, String> maps = Maps.toMap(keys, new Function<String, String>() {
            @Override public String apply(String input) {
                return input;
            }
        });
        Assert.assertEquals("xiaog", maps.get("xiaog"));
    }

    @Test public void test_transformEntries() {
        Map<String, String> maps = ImmutableMap.of("xiaog", "1", "lidong", "2", "xiaow", "3");
        Map<String, String> transformMap =
            Maps.transformEntries(maps, new Maps.EntryTransformer<String, String, String>() {
                @Override public String transformEntry(String key, String value) {
                    if (key.equals("xiaog")) {
                        return value + "_new";
                    }
                    return value;
                }
            });
        Assert.assertEquals("1_new", transformMap.get("xiaog"));
    }
}
