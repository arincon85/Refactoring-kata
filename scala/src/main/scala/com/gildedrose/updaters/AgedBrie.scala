package com.gildedrose.updaters

import com.gildedrose.Item

/**
  * Created by arincon on 7/03/17.
  */
class AgedBrie extends Updater{
  override def update(item: Item): Unit = {
    item.sellIn = item.sellIn - 1
    if (qualityLessThanMax(item)) {
      item.quality = item.quality + 1
      if (sellInDatePassed(item)) {
        item.quality = item.quality + 1
      }
    }
  }
}
