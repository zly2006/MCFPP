package top.mcfpp.model.accessor

import top.mcfpp.core.lang.UnknownVar
import top.mcfpp.core.lang.Var
import top.mcfpp.model.CanSelectMember
import top.mcfpp.model.Class
import top.mcfpp.model.CompoundData
import top.mcfpp.model.function.Function
import top.mcfpp.type.MCFPPType

class FunctionAccessor(field: Var<*>, d: CompoundData): AbstractAccessor(field) {

    var function: Function

    init {
        function = Function("get_${field.identifier}", d.namespace, null)
        function.returnType = field.type
        function.field.putVar("field", field)
        val thisObj = Class.currClass!!.getType().build("this", function)
        function.field.putVar("this",thisObj)
        function.owner = d
    }

    override fun getter(caller: CanSelectMember): Var<*> {
        function.invoke(ArrayList(), caller)
        return function.returnVar
    }
}