(ns settings.vim.mode.visual
  (:require [settings.vim.mode.util :refer [convert-after convert-commands]]))

(def before-commands
  {">" "editor.action.indentLines"
   "<" "editor.action.indentLines"
   :w "paredit.sexpRangeExpansion"
;;  
   })


(def before-after
  {";" "$"
   "," :C-d
   :h "^"
   :i :k ;; beginning of line
   "ㅑ" :k  ;; up
   :j :h
   :k :j  ;; left
   :m :C-u   ;; down
   [:p] [:p :g :v :y] ;; page half down
   :s :S  ;; page half up
   :t "%"
  ;;  
   })

(defn vim-visual []
  {"vim.visualModeKeyBindingsNonRecursive"
   (concat (convert-after before-after)
           (convert-commands before-commands))})
