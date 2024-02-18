(ns settings.vim.mode.normal
  (:require [settings.vim.mode.util :refer [convert-after convert-commands]]))

(def before-commands
  {"." "editor.action.quickFix"
   ":" "workbench.action.showCommands"
   "[" "workbench.action.navigateBackInNavigationLocations"
   "]" 	"workbench.action.navigateForwardInNavigationLocations"
   [:b] "editor.action.revealDefinition"
   [:c :n] "clojureLsp.refactor.cleanNs"
   [:c :o] "workbench.action.closeEditorsInOtherGroups"
   [:g :m] "magit.status"
   [:g :s] "workbench.action.gotoSymbol"
   [:g :a] "workbench.action.showAllSymbols"
   [:K] "editor.action.insertLineAfter" ;; 대문자 K
   [:m :p] "markdown.showPreview"
   [:s :a] "clojureLsp.refactor.addMissingLibspec"
   [:s :b] "paredit.barfSexpForward"
   [:s :c] ["paredit.selectForwardSexp"
            "execCopy"
            "extension.vim_escape"]
   [:s :d] "paredit.spliceSexp"
   [:s :f] "paredit.slurpSexpForward"
   [:s :g] "workbench.view.scm"

   [:s :h] "workbench.action.splitEditor"
   [:s :k] "paredit.killListForward"
   [:s :n] "clojureLsp.refactor.cleanNs"
   [:s :r] "paredit.raiseSexp"
   [:s :s] "workbench.action.toggleSidebarVisibility"

   [:s :x]  ["paredit.selectForwardSexp",
             "editor.action.clipboardCutAction",
             "extension.vim_escape"]
   ;; [:r :b] "debug.removeBreakpoint"
   ;; [:r :s] "workbench.action.debug.restart"
   [:s :z] "workbench.action.toggleZenMode"
  ;; MODIFIER
   ;; [:D-b] "workbench.action.navigateForwardInNavigationLocations"
   [:S-j] "workbench.action.previousEditorInGroup" ;; left window
   [:S-l] "workbench.action.nextEditorInGroup" ;; right window
   [:S-h] "workbench.action.focusPreviousGroup" ;; right window
   [:S-t] "workbench.action.terminal.focusPrevious" ;; right window
   [:S-r] "editor.action.rename"
   [:D-l] "workbench.action.terminal.focusNextPane"
  ;; LEADER

   [:leader :a :e] "workbench.view.explorer"
   [:leader :a :f] "workbench.action.findInFiles"
;;  [:leader :a :r] "clojureLsp.refactor.addMissingLibspec"
   [:leader :a :m] "clojureLsp.refactor.addMissingLibspec"
   [:leader :a :x] "workbench.view.extensions"
   [:leader :b] "bookmarks.listFromAllFiles"
   [:leader :c :e] "calva.evaluateSelection"
   [:leader :c :h] "calva.clearReplHistory"
   [:leader :c :j] "calva.jackIn"
   [:leader :c :i] "calva.clearInlineResults"
   [:leader :c :o] "workbench.action.closeEditorsInOtherGroups"
   [:leader :d :l] "paredit.killListForward"
   [:leader :d :f] "paredit.killSexpForward"
   [:leader :d :s] "paredit.spliceSexp"
   [:leader :d :j] "paredit.splitSexp"
   [:leader :d :w] "workbench.action.decreaseViewWidth"
   [:leader :e :e] "workbench.files.action.showActiveFileInExplorer"
   [:leader :e :f] "clojureLsp.refactor.extractFunction"
   [:leader :f :a] "clojureLsp.refactor.threadFirstAll"
   [:leader :f :f] "actions.find"
   [:leader :f :m] 	"calva-fmt.alignCurrentForm"
   [:leader :f :l] "calva.loadFile"
   [:leader :f :t] "calva-fmt.trimCurrentFormWhiteSpace"
   [:leader :g :g] "magit.status"
   [:leader :h]	"workbench.action.moveEditorToLeftGroup"
   [:leader :i :s] "clojureLsp.refactor.inlineSymbol"
   [:leader :i :w] "workbench.action.increaseViewWidth"
   [:leader :i :h] "workbench.action.increaseViewHeight"
   [:leader :leader :k] "bookmarks.list"
;;  FIX 
   [:leader :k]	"bookmarks.toggle"
  ;;  FIX
   [:leader :j]	"bookmarks.jumpToPrevious"
  ;;  FIX
   [:leader :l]	"bookmarks.jumpToNext"
   [:leader :k :b] "paredit.killSexpBackward"
   [:leader :k :f] "paredit.killSexpForward"
   [:leader :k :l :b]	"paredit.killListBackward"
   [:leader :k :l :f]	"paredit.killListForward"
   [:leader :k :r] "paredit.killRight"
   [:leader :l :f] "calva.loadFile"
   [:leader :l :i] "clojureLsp.refactor.introduceLet"
   [:leader :l :p] "clojureLsp.refactor.moveToLet"
   [:leader :l :s] "paredit.splitSexp"
   [:leader :l :j] "paredit.joinSexp"
   [:leader :m]	"bookmarks.toggle"
   [:leader :n] "extension.advancedNewFile"
   [:leader :o]	"workbench.action.quickOpen"
   [:leader :p] "workbench.action.showCommands"
   [:leader :q] "workbench.action.closeActiveEditor"
   [:leader :r :a] "paredit.raiseSexp"
   [:leader :r :b] "debug.removeBreakpoint"
   ;; [:leader :r :s] "workbench.action.debug.restart"
   [:leader :r :c] "paredit.rewrapCurly"
   [:leader :r :q] "paredit.rewrapQuote"
   [:leader :r :o] {:command "calva.runCustomREPLCommand",
                    :args {:snippet "(require '[portal.api :as p]) (def p (p/open)) (add-tap #'p/submit)"}}
   [:leader :r :p] "paredit.rewrapParens"
   [:leader :r :s] "paredit.rewrapSquare"
   [:leader :r :t] "calva.runAllTests"
   [:leader :s :a] "editor.action.sourceAction"
   [:leader :s :f] ["paredit.selectForwardSexp"
                    "execCopy"
                    "extension.vim_escape"]
   [:leader :s :k :b] "paredit.spliceSexpKillBackward"
   [:leader :s :k :f] "paredit.spliceSexpKillForward"
   [:leader :s :s] "paredit.sexpRangeContraction"
   [:leader :s :t] "paredit.rangeForDefun"
   [:leader :s :v] "workbench.action.toggleSidebarVisibility"
   [:leader :s :r] ["paredit.selectRight"
                    "editor.action.clipboardCopyAction"
                    "vim_escape"]
   [:leader :s :w] "paredit.sexpRangeExpansion"
   [:leader :s :x] ["paredit.selectForwardSexp"
                    "editor.action.clipboardCutAction"
                    "extension.vim_escape"]
   [:leader :t :e] {:command "calva.runCustomREPLCommand",
                    :args {:snippet "(tap> (Throwable->map *e))"}}
   [:leader :t :i] {:command "calva.runCustomREPLCommand",
                    :args {:snippet "(tap> (let [v (read-string (clojure.string/replace (read-line) \"*v\" \"@dev/*v\"))] (eval v)))"}}
   [:leader :t :l] {:command "calva.runCustomREPLCommand",
                    :args {:snippet "(tap> *1)"}}
   [:leader :t :s] [{:command "calva.loadFile"}
                    {:command "calva.runCustomREPLCommand",
                     :args {:snippet "(clojure.test/test-vars [#'$top-level-defined-symbol])"}}]
   [:leader :t :t] [{:command "calva.loadFile"}
                    {:command "calva.runCustomREPLCommand",
                     :args {:snippet "(run-tests)"}}]
   [:leader :u :a] "clojureLsp.refactor.unwindAll"
   [:leader :u :t] "clojureLsp.refactor.unwindThread"
   [:leader :w :c] "paredit.wrapAroundCurly"
   [:leader :w :e] "workbench.view.explorer"
   [:leader :w :j] "workbench.action.moveActiveEditorGroupLeft"
   [:leader :w :l] "workbench.action.moveActiveEditorGroupRight"
   [:leader :w :s] "workbench.action.splitEditor"
   [:leader :w :p] "paredit.wrapAroundParens"
   [:leader :w :q] "paredit.wrapAroundQuote"
   [:leader :x] "workbench.action.closeActiveEditor"
   [:leader :y] {:command "calva.runCustomREPLCommand",
                 :args {:snippet "(tap> $top-level-form)"}}
   [:leader :z] "workbench.action.toggleZenMode"
   [:leader "."] "workbench.action.quickFix"
   [:leader ";"] "workbench.action.moveEditorToRightGroup"
   [:leader ","] "workbench.action.focusNextGroup"


  ;;  [:leader :m] 	"editor.action.toggleMinimap"
  ;;  [:leader :m] 	"workbench.action.focusPreviousGroup"
  ;;  [:leader :l :a] "clojureLsp.refactor.threadLastAll"
  ;;  [:leader :l :e] "clojureLsp.refactor.expandLet"
  ;;  
   })


(def before-after
  {"=" :i
   ";" :S-a ;; insert end cursor
   "," :C-d ;; page half down
   "m" :C-u  ;; page half up
   "D-," ","
   "D-." "."
   "C-." "."
   "D-m" :m
   :a :o
   [:c :i "\""] ["\"" "_" :c :i "\""]
   [:d :d] ["\"" "_" :d :d]
   :f [:leader :leader :leader :b :d :w]
   :F [:leader :leader :leader :j]
   :h "^" ;; beginning of line
   :i :k  ;; up
   "ㅑ" :k
   :I :i  ;; insert 
   :j :h  ;; left
   :k :j  ;; down
   :o :i ;; insert
   "ㅐ" :i
   :O :o  ;; insert new line
   :p :S-p
   :U :C-r ;; redo
   :t "%"
   :q :b
   :x  ["\"" "_" :x]
   [:C-w :j] [:C-w :h] ;; left window
   [:leader :d :9] [:d :s "("]
   [:leader :d :0] [:d :s ")"]
   [:leader :d "'"] [:d :s "\\"]
   [:leader :d "["] [:d :s "["]
   [:leader :d "]"] [:d :s "{"]
   [:leader "'"] ["y" "s" "i" "w" "\""]
   [:leader :9] ["y" "s" "i" "w" "("]
   [:leader "["] ["y" "s" "i" "w" "["]
   [:leader "]"] ["y" "s" "i" "w" "{"]
   [:leader "/"] [:leader :leader "/"]
  ;;  
   })

(defn vim-normal []
  {"vim.normalModeKeyBindingsNonRecursive"
   (concat (convert-after before-after)
           (convert-commands before-commands))})


(comment
  (concat (convert-after before-after)
          (convert-commands before-commands))
  :rcf)
