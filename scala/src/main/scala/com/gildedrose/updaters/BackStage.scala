package com.gildedrose.updaters

import com.gildedrose.Item

class BackStage extends Updater{
  override def update(item: Item): Unit = {
    item.sellIn = item.sellIn - 1
    if (qualityLessThanMax(item)) {
      item.quality = item.quality + 1
      if (item.sellIn < 11) {
        if (qualityLessThanMax(item)) {
          item.quality = item.quality + 1
        }
      }
      if (item.sellIn < 6) {
        if (qualityLessThanMax(item)) {
          item.quality = item.quality + 1
        }
      }
      if (sellInDatePassed(item)) {
        item.quality = item.quality - item.quality
      }
    }
  }
}
