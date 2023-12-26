(ns settings.vim.mode.insert
  (:require [settings.vim.mode.util :refer [convert-after]]))


(def before-after
  {[:j :j] :esc
   ["ㅓ" "ㅓ"] :esc})


(defn vim-insert []
  {"vim.insertModeKeyBindingsNonRecursive"
   (convert-after before-after)})
