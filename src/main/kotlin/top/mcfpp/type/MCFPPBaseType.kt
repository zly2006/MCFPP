package top.mcfpp.type

import net.querz.nbt.tag.IntArrayTag
import net.querz.nbt.tag.StringTag
import top.mcfpp.lib.EntitySelector
import top.mcfpp.lib.PlainChatComponent
import top.mcfpp.model.Class
import top.mcfpp.core.lang.*
import top.mcfpp.model.CompoundData
import top.mcfpp.model.FieldContainer
import top.mcfpp.util.LogProcessor

/**
 * 类型单例
 */
class MCFPPBaseType {
    object Any: MCFPPType(parentType = listOf()){

        override val objectData: CompoundData
            get() = MCAny.data

        override val typeName: kotlin.String
            get() = "any"

        override fun build(identifier: kotlin.String, container: FieldContainer): Var<*> = MCAny(container, identifier)
        override fun build(identifier: kotlin.String): Var<*> = MCAny(identifier)
        override fun build(identifier: kotlin.String, clazz: Class): Var<*> = MCAny(clazz, identifier)
        override fun buildUnConcrete(identifier: kotlin.String, container: FieldContainer): Var<*> = MCAny(container, identifier)
        override fun buildUnConcrete(identifier: kotlin.String): Var<*> = MCAny(identifier)
        override fun buildUnConcrete(identifier: kotlin.String, clazz: Class): Var<*> = MCAny(clazz, identifier)

    }
    object Int: MCFPPType(parentType = listOf(Any)){

        override val objectData: CompoundData
            get() = MCInt.data

        override val typeName: kotlin.String
            get() = "int"

        override fun build(identifier: kotlin.String, container: FieldContainer): Var<*> = MCIntConcrete(container, 0, identifier)
        override fun build(identifier: kotlin.String): Var<*> = MCIntConcrete(0, identifier)
        override fun build(identifier: kotlin.String, clazz: Class): Var<*> = MCIntConcrete(clazz, 0, identifier)
        override fun buildUnConcrete(identifier: kotlin.String, container: FieldContainer): Var<*> = MCInt(container, identifier)
        override fun buildUnConcrete(identifier: kotlin.String): Var<*> = MCInt(identifier)
        override fun buildUnConcrete(identifier: kotlin.String, clazz: Class): Var<*> = MCInt(clazz, identifier)


    }
    object String: MCFPPType(parentType = listOf(Any)){

        override val objectData: CompoundData
            get() = MCString.data

        override val typeName: kotlin.String
            get() = "string"

        override fun build(identifier: kotlin.String, container: FieldContainer): Var<*> = MCStringConcrete(container, StringTag(""), identifier)
        override fun build(identifier: kotlin.String): Var<*> = MCStringConcrete(StringTag(""), identifier)
        override fun build(identifier: kotlin.String, clazz: Class): Var<*> = MCStringConcrete(clazz, StringTag(""), identifier)
        override fun buildUnConcrete(identifier: kotlin.String, container: FieldContainer): Var<*> = MCString(container, identifier)
        override fun buildUnConcrete(identifier: kotlin.String): Var<*> = MCString(identifier)
        override fun buildUnConcrete(identifier: kotlin.String, clazz: Class): Var<*> = MCString(clazz, identifier)
    }

    object Float: MCFPPType(parentType = listOf(Any)){

        override val objectData: CompoundData
            get() = MCFloat.data

        override val typeName: kotlin.String
            get() = "float"

        override fun build(identifier: kotlin.String, container: FieldContainer): Var<*> = MCFloatConcrete(container, 0.0f, identifier)
        override fun build(identifier: kotlin.String): Var<*> = MCFloatConcrete(0.0f, identifier)
        override fun build(identifier: kotlin.String, clazz: Class): Var<*> = MCFloatConcrete(clazz, 0.0f, identifier)
        override fun buildUnConcrete(identifier: kotlin.String, container: FieldContainer): Var<*> = MCFloat(container, identifier)
        override fun buildUnConcrete(identifier: kotlin.String): Var<*> = MCFloat(identifier)
        override fun buildUnConcrete(identifier: kotlin.String, clazz: Class): Var<*> = MCFloat(clazz, identifier)

    }
    object Bool: MCFPPType(parentType = listOf(Any)){

        override val objectData: CompoundData
            get() = MCBool.data

        override val typeName: kotlin.String
            get() = "bool"

        override fun build(identifier: kotlin.String, container: FieldContainer): Var<*> = MCBoolConcrete(container, false, identifier)
        override fun build(identifier: kotlin.String): Var<*> = MCBoolConcrete(false, identifier)
        override fun build(identifier: kotlin.String, clazz: Class): Var<*> = MCBoolConcrete(clazz, false, identifier)
        override fun buildUnConcrete(identifier: kotlin.String, container: FieldContainer): Var<*> = MCBool(container, identifier)
        override fun buildUnConcrete(identifier: kotlin.String): Var<*> = MCBool(identifier)
        override fun buildUnConcrete(identifier: kotlin.String, clazz: Class): Var<*> = MCBool(clazz, identifier)
    }
    object Type: MCFPPType(parentType = listOf()){

        override val objectData: CompoundData
            get() = data

        override val typeName: kotlin.String
            get() = "type"

        override fun build(identifier: kotlin.String, container: FieldContainer): Var<*> = MCFPPTypeVar(identifier = identifier)
        override fun build(identifier: kotlin.String): Var<*> = MCFPPTypeVar(identifier = identifier)
        override fun build(identifier: kotlin.String, clazz: Class): Var<*> = MCFPPTypeVar(identifier = identifier)
        override fun buildUnConcrete(identifier: kotlin.String, container: FieldContainer): Var<*> = MCFPPTypeVar(identifier = identifier)
        override fun buildUnConcrete(identifier: kotlin.String): Var<*> = MCFPPTypeVar(identifier = identifier)
        override fun buildUnConcrete(identifier: kotlin.String, clazz: Class): Var<*> = MCFPPTypeVar(identifier = identifier)
    }
    object Void: MCFPPType(parentType = listOf()){

        override val objectData: CompoundData
            get() = top.mcfpp.core.lang.Void.data

        override val typeName: kotlin.String
            get() = "void"

        override fun build(identifier: kotlin.String, container: FieldContainer): Var<*> = top.mcfpp.core.lang.Void
        override fun build(identifier: kotlin.String): Var<*> = top.mcfpp.core.lang.Void
        override fun build(identifier: kotlin.String, clazz: Class): Var<*> = top.mcfpp.core.lang.Void
        override fun buildUnConcrete(identifier: kotlin.String, container: FieldContainer): Var<*> = top.mcfpp.core.lang.Void
        override fun buildUnConcrete(identifier: kotlin.String): Var<*> = top.mcfpp.core.lang.Void
        override fun buildUnConcrete(identifier: kotlin.String, clazz: Class): Var<*> = top.mcfpp.core.lang.Void
    }
    object Selector: MCFPPType(parentType = listOf(BaseEntity)){

        override val objectData: CompoundData
            get() = SelectorVar.data

        override val typeName: kotlin.String
            get() = "selector"

        override fun build(identifier: kotlin.String, container: FieldContainer): Var<*>
            = SelectorVarConcrete(EntitySelector(EntitySelector.Companion.SelectorType.ALL_ENTITIES), container, identifier)
        override fun build(identifier: kotlin.String): Var<*>
            = SelectorVarConcrete(EntitySelector(EntitySelector.Companion.SelectorType.ALL_ENTITIES), identifier)
        override fun build(identifier: kotlin.String, clazz: Class): Var<*>
            = SelectorVarConcrete(EntitySelector(EntitySelector.Companion.SelectorType.ALL_ENTITIES), clazz, identifier)
        override fun buildUnConcrete(identifier: kotlin.String, container: FieldContainer): Var<*>
            = SelectorVar(EntitySelector.Companion.SelectorType.ALL_ENTITIES, container, identifier)
        override fun buildUnConcrete(identifier: kotlin.String): Var<*>
            = SelectorVar(EntitySelector.Companion.SelectorType.ALL_ENTITIES, identifier)
        override fun buildUnConcrete(identifier: kotlin.String, clazz: Class): Var<*>
            = SelectorVar(EntitySelector.Companion.SelectorType.ALL_ENTITIES, clazz, identifier)

    }
    object JavaVar: MCFPPType(parentType = listOf(Any)){

        override val objectData: CompoundData
            get() = top.mcfpp.core.lang.JavaVar.data
        override val typeName: kotlin.String
            get() = "JavaVar"

        override fun build(identifier: kotlin.String, container: FieldContainer): Var<*> = JavaVar(container, null, identifier)
        override fun build(identifier: kotlin.String): Var<*> = JavaVar(null, identifier)
        override fun build(identifier: kotlin.String, clazz: Class): Var<*> = JavaVar(clazz, null, identifier)
        override fun buildUnConcrete(identifier: kotlin.String, container: FieldContainer): Var<*> = JavaVar(container, null, identifier)
        override fun buildUnConcrete(identifier: kotlin.String): Var<*> = JavaVar(null, identifier)
        override fun buildUnConcrete(identifier: kotlin.String, clazz: Class): Var<*> = JavaVar(clazz, null, identifier)
    }
    object BaseEntity: MCFPPType(parentType = listOf(Any)){

        override val objectData: CompoundData
            get() = EntityVar.data

        override val typeName: kotlin.String
            get() = "entity"

        override fun build(identifier: kotlin.String, container: FieldContainer): Var<*> = EntityVarConcrete(container, IntArrayTag(intArrayOf(0,0,0,0)), identifier)
        override fun build(identifier: kotlin.String): Var<*> = EntityVarConcrete(IntArrayTag(intArrayOf(0,0,0,0)), identifier)
        override fun build(identifier: kotlin.String, clazz: Class): Var<*> = EntityVarConcrete(clazz, IntArrayTag(intArrayOf(0,0,0,0)), identifier)
        override fun buildUnConcrete(identifier: kotlin.String, container: FieldContainer): Var<*> = EntityVar(container, identifier)
        override fun buildUnConcrete(identifier: kotlin.String): Var<*> = EntityVar(identifier)
        override fun buildUnConcrete(identifier: kotlin.String, clazz: Class): Var<*> = EntityVar(clazz, identifier)
    }
    object JsonText: MCFPPType(parentType = listOf(MCFPPNBTType.NBT)){

        override val objectData: CompoundData
            get() = top.mcfpp.core.lang.JsonText.data

        override val typeName: kotlin.String
            get() = "text"

        override fun build(identifier: kotlin.String, container: FieldContainer): Var<*> = JsonTextConcrete(container, PlainChatComponent(""), identifier)
        override fun build(identifier: kotlin.String): Var<*> = JsonTextConcrete(PlainChatComponent(""), identifier)
        override fun build(identifier: kotlin.String, clazz: Class): Var<*> = JsonTextConcrete(clazz, PlainChatComponent(""), identifier)
        override fun buildUnConcrete(identifier: kotlin.String, container: FieldContainer): Var<*> = JsonText(container, identifier)
        override fun buildUnConcrete(identifier: kotlin.String): Var<*> = JsonText(identifier)
        override fun buildUnConcrete(identifier: kotlin.String, clazz: Class): Var<*> = JsonText(clazz, identifier)
    }

    object Range: MCFPPType(parentType = listOf(Any)){

        override val objectData: CompoundData
            get() = RangeVar.data

        override val typeName: kotlin.String
            get() = "range"

        override fun build(identifier: kotlin.String, container: FieldContainer): Var<*> = RangeVarConcrete(container, 0f to 0f, identifier)
        override fun build(identifier: kotlin.String): Var<*> = RangeVarConcrete(0f to 0f, identifier)
        override fun build(identifier: kotlin.String, clazz: Class): Var<*> = RangeVarConcrete(clazz, 0f to 0f, identifier)
        override fun buildUnConcrete(identifier: kotlin.String, container: FieldContainer): Var<*> = RangeVar(container, identifier)
        override fun buildUnConcrete(identifier: kotlin.String): Var<*> = RangeVar(identifier)
        override fun buildUnConcrete(identifier: kotlin.String, clazz: Class): Var<*> = RangeVar(clazz, identifier)
    }

    object CommandReturn: MCFPPType(parentType = listOf(Any)){

        override val objectData: CompoundData
            get() = top.mcfpp.core.lang.CommandReturn.data

        override val typeName: kotlin.String
            get() = "CommandReturn"

        override fun build(identifier: kotlin.String, container: FieldContainer): Var<*> {
            LogProcessor.error("Cannot build var from type: $typeName")
            return UnknownVar(identifier)
        }
        override fun build(identifier: kotlin.String): Var<*> {
            LogProcessor.error("Cannot build var from type: $typeName")
            return UnknownVar(identifier)
        }
        override fun build(identifier: kotlin.String, clazz: Class): Var<*> {
            LogProcessor.error("Cannot build var from type: $typeName")
            return UnknownVar(identifier)
        }
        override fun buildUnConcrete(identifier: kotlin.String, container: FieldContainer): Var<*> {
            LogProcessor.error("Cannot build var from type: $typeName")
            return UnknownVar(identifier)
        }
        override fun buildUnConcrete(identifier: kotlin.String): Var<*> {
            LogProcessor.error("Cannot build var from type: $typeName")
            return UnknownVar(identifier)
        }
        override fun buildUnConcrete(identifier: kotlin.String, clazz: Class): Var<*> {
            LogProcessor.error("Cannot build var from type: $typeName")
            return UnknownVar(identifier)
        }
    }

}

class LimitedSelectorType(val limit: Int): MCFPPType(parentType = listOf(MCFPPBaseType.BaseEntity)){

    override val objectData: CompoundData
        get() = SelectorVar.data

    override val typeName: String
        get() = "selector[$limit]"

    override fun build(identifier: String, container: FieldContainer): Var<*> = SelectorVarConcrete(EntitySelector(EntitySelector.Companion.SelectorType.ALL_ENTITIES).limit(limit), container, identifier)
    override fun build(identifier: String): Var<*> = SelectorVarConcrete(EntitySelector(EntitySelector.Companion.SelectorType.ALL_ENTITIES).limit(limit), identifier)
    override fun build(identifier: String, clazz: Class): Var<*> = SelectorVarConcrete(EntitySelector(EntitySelector.Companion.SelectorType.ALL_ENTITIES).limit(limit), clazz, identifier)
    override fun buildUnConcrete(identifier: String, container: FieldContainer): Var<*> = SelectorVar(EntitySelector.Companion.SelectorType.ALL_ENTITIES, container, identifier)
    override fun buildUnConcrete(identifier: String): Var<*> = SelectorVar(EntitySelector.Companion.SelectorType.ALL_ENTITIES, identifier)
    override fun buildUnConcrete(identifier: String, clazz: Class): Var<*> = SelectorVar(EntitySelector.Companion.SelectorType.ALL_ENTITIES, clazz, identifier)

}

//class MCFPPEntityType(
//    val resourceLocation: ResourceLocation
//) : MCFPPType(listOf(MCFPPBaseType.BaseEntity), Entity.data) {
//    init {
//       registerType({ it.contains(regex) }) {
//          val matcher = regex.find(it)!!.groupValues
//          MCFPPEntityType(ResourceLocation(matcher[1], matcher[2]))
//       }
//    }
//    companion object{
//        val regex = Regex("^entity\\((.+):(.+)\\)$")
//    }
//}

