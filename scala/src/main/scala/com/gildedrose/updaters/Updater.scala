package com.gildedrose.updaters

import com.gildedrose.Item

trait Updater {
  def update(item: Item)

  def qualityLessThanMax(item: Item) = {
    item.quality < 50
  }

  def sellInDatePassed(item: Item) = {
    item.sellIn < 0
  }

  def increaseQuality(item: Item) = item.quality = item.quality + 1

  def decreaseQuality(item: Item) = {
    if (item.quality > 0)
      item.quality = item.quality - 1
  }
  def decreaseSellIn(item: Item) = {
    item.sellIn = item.sellIn - 1
  }
}
