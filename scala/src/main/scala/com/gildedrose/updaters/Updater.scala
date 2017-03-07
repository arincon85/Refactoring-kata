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
}
